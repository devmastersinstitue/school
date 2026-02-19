package com.school.controller;

import com.school.handler.StudentHandler;
import com.school.model.StudentModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentHandler studentHandler;

    public StudentModel create() {
        return null;
    }
}
