package com.school.controller;

import com.school.handler.StudentHandler;
import com.school.model.StudentModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentHandler studentHandler;

    @PostMapping
    public StudentModel create(@RequestBody StudentModel model) {
        return studentHandler.create(model);
    }
}
