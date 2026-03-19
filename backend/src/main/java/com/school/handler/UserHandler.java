package com.school.handler;

import com.school.domain.User;
import com.school.model.UserModel;
import com.school.service.UserService;
import com.school.transformer.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserHandler {
    private final UserService userService;
    private final UserTransformer userTransformer;

    public UserModel create(UserModel userModel) {
        return userTransformer.toModel(userService.create(userTransformer.toEntity(userModel)));
    }

    public UserModel login(String email, String password) {
        return userTransformer.toModel(userService.login(email, password));
    }
}
