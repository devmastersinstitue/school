package com.school.transformer;

import com.school.domain.User;
import com.school.domain.UserRole;
import com.school.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserTransformer extends Transformer<User, UserModel>{
    @Override
    public User toEntity(UserModel model) {
        if (model == null)
            return null;
        return User.builder()
                .id(model.getId() != null ? model.getId() : UUID.randomUUID())
                .userName(model.getUserName())
                .email(model.getEmail())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .password(model.getPassword())
                .userRole(UserRole.valueOf(model.getUserRole()))
                .build();
    }

    @Override
    public UserModel toModel(User entity) {
        if(entity == null)
            return null;
        return UserModel.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .password(entity.getPassword())
                .userRole(String.valueOf(entity.getUserRole()))
                .build();
    }
}
