package com.school.controller;

import com.school.handler.GradeHandler;
import com.school.model.GradeModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/grade")
public class GradeController {
    private final GradeHandler gradeHandler;

    @PostMapping
    public GradeModel create(@RequestBody GradeModel model){
        return gradeHandler.create(model);
    }

    @GetMapping
    public List<GradeModel> getAllGrade(){
        return gradeHandler.getAll();
    }
}
