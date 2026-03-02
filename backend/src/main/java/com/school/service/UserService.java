package com.school.service;

import com.school.domain.User;
import com.school.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        Optional<User> optionalUser = userRepository.findByEmailAndUserName(user.getEmail(), user.getUserName());
        if(optionalUser.isEmpty())
            userRepository.save(user);
        return user;
    }
}
