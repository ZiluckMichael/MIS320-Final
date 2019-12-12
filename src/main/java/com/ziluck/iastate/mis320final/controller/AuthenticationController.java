package com.ziluck.iastate.mis320final.controller;

import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.model.dto.AuthRequest;
import com.ziluck.iastate.mis320final.model.dto.AuthResponse;
import com.ziluck.iastate.mis320final.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/noauth")
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    @ResponseBody
    @ApiResponses({
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 422, message = "Invalid username/password supplied")
    })
    public AuthResponse requestToken(@RequestBody AuthRequest authRequest) {
        return new AuthResponse(userService.signin(authRequest));
    }

    @PostMapping("/register")
    @ResponseBody
    @ApiResponses({
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 422, message = "Username is already in use"),
        @ApiResponse(code = 500, message = "Expired or invalid JWT token")
    })
    public AuthResponse registerUser(@RequestBody WebUser user) {
        return new AuthResponse(userService.signup(user));
    }
}
