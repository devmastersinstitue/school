package com.school.controller;

import com.school.handler.UserHandler;
import com.school.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final UserHandler userHandler;

    @PostMapping("/crete")
    public UserModel create(@RequestBody UserModel userModel){
        return userHandler.create(userModel);
    }
}
