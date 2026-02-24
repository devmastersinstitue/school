package com.school.controller;

import com.school.domain.StudentDomain;
import com.school.handler.StudentHandler;
import com.school.model.StudentModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentHandler studentHandler;

    @PostMapping
    public StudentModel create(@RequestBody StudentModel model) {

        return studentHandler.create(model);
    }

    @GetMapping
    public List<StudentModel> getAllStudent() {
        return studentHandler.getAll();
    }

}
