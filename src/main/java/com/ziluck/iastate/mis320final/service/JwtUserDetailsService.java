package com.ziluck.iastate.mis320final.service;

import com.ziluck.iastate.mis320final.exception.AuthenticationException;
import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.repository.WebUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final WebUserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public JwtUserDetailsService(WebUserRepository userRepository,
                                 BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        WebUser user = userRepository.findByEmail(username);
        if (user == null) {
            return null;
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public WebUser registerUser(WebUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return saveUser(user);
    }

    public WebUser saveUser(WebUser user) {
        if (loadUserByUsername(user.getEmail()) != null) {
            throw new AuthenticationException("Username already taken.");
        }
        return userRepository.save(user);
    }
}
