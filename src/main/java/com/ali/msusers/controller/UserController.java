package com.ali.msusers.controller;

import com.ali.msusers.dto.LoginResponseDto;
import com.ali.msusers.dto.UserLoginDto;
import com.ali.msusers.dto.UserRegistrationDto;
import com.ali.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserRegistrationDto user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody UserLoginDto user) {
        return userService.loginUser(user);
    }

    @PostMapping("/add-order")
    public void addOrder(@RequestParam String token){
        userService.addOrder(token);
    }
}
