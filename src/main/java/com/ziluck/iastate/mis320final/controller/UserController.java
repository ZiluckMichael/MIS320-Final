package com.ziluck.iastate.mis320final.controller;

import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public WebUser getUser(String username) {
        WebUser user = userService.search(username);
        if (user != null) {
            user.setPassword(null);
        }
        return user;
    }
}
