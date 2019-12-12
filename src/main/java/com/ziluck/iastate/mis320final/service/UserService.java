package com.ziluck.iastate.mis320final.service;

import com.ziluck.iastate.mis320final.exception.AuthenticationException;
import com.ziluck.iastate.mis320final.model.Guest;
import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.model.dto.AuthRequest;
import com.ziluck.iastate.mis320final.repository.GuestRepository;
import com.ziluck.iastate.mis320final.repository.WebUserRepository;
import com.ziluck.iastate.mis320final.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {
    private final WebUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final GuestRepository guestRepository;

    public UserService(WebUserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider,
                       AuthenticationManager authenticationManager, GuestRepository guestRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.guestRepository = guestRepository;
    }

    public String signin(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            return jwtTokenProvider.createToken(authRequest.getUsername(), userRepository.findByEmail(authRequest.getUsername())
                .getWebRoleListButMakeItHaveASuperWeirdNameSoThereIsNoWayThatJPAOrHibernateCanTryAnySortOfFunnyBusinessOnHere());
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid username/password supplied");
        }
    }

    public String signup(WebUser user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            Guest guest = new Guest();
            guest.setPersonId(user.getId());
            guest.setFirstName(user.getFirstName());
            guest.setLastName(user.getLastName());
            guest.setBirthDate(Date.valueOf("1997-08-02"));
            guest.setPhone("2038854970");
            guest.setPhoneExt(null);
            guest.setRewardsNumber("000000000000");
            guest.setRewardsPoints(0);
            guestRepository.save(guest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setId((int) guest.getPersonId());
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getEmail(),
                user.getWebRoleListButMakeItHaveASuperWeirdNameSoThereIsNoWayThatJPAOrHibernateCanTryAnySortOfFunnyBusinessOnHere());
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username is already in use");
        }
    }

    public WebUser search(String username) {
        WebUser user = userRepository.findByEmail(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user doesn't exist");
        }
        return user;
    }

    public WebUser whoami(HttpServletRequest req) {
        return userRepository.findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByEmail(username)
            .getWebRoleListButMakeItHaveASuperWeirdNameSoThereIsNoWayThatJPAOrHibernateCanTryAnySortOfFunnyBusinessOnHere());
    }

}
