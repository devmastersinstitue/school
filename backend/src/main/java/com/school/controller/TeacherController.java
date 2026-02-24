package com.school.controller;

import com.school.handler.SubjectHandler;
import com.school.handler.TeacherHandler;
import com.school.model.SubjectModel;
import com.school.model.TeacherModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherHandler teacherHandler;

    @PostMapping
    public TeacherModel create(@RequestBody TeacherModel model){
        return teacherHandler.create(model);
    }

    @GetMapping
    public List<TeacherModel> getAllTeacher(){
        return teacherHandler.getAll();
    }

}
