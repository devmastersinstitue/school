package com.school.controller;

import com.school.handler.SubjectHandler;
import com.school.model.StudentModel;
import com.school.model.SubjectModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/subject")
public class SubjectController {
    private final SubjectHandler subjectHandler;

    @PostMapping
    public SubjectModel create(@RequestBody SubjectModel model){
        return subjectHandler.create(model);

    }
    @GetMapping
    public List<SubjectModel> getAllSubjects() {
        return subjectHandler.getAll();
    }
}
