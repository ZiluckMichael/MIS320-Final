package com.ziluck.iastate.mis320final.service;

import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.repository.WebUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringUserDetails implements UserDetailsService {
    private final WebUserRepository userRepository;

    public SpringUserDetails(WebUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        final WebUser user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return org.springframework.security.core.userdetails.User//
            .withUsername(username)//
            .password(user.getPassword())//
            .authorities(user.getRoleList())//
            .accountExpired(false)//
            .accountLocked(false)//
            .credentialsExpired(false)//
            .disabled(false)//
            .build();
    }
}
