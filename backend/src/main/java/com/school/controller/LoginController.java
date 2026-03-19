package com.school.controller;

import com.school.domain.User;
import com.school.handler.UserHandler;
import com.school.model.UserModel;
import com.school.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final UserHandler userHandler;

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel){

        return userHandler.create(userModel);
    }

    @PostMapping("/authenticate")
    public UserModel login(@RequestParam String email,
                           @RequestParam String password) {

        return userHandler.login(email, password);
    }

}
