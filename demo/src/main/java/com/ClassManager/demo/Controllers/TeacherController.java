package com.ClassManager.demo.Controllers;

import com.ClassManager.demo.Models.Teachers;
import com.ClassManager.demo.Services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teachers> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/subject")
    public List<Teachers> getTeachersBySubject(@RequestParam String subject) {
        return teacherService.getTeachersBySubject(subject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teachers addTeacher(@RequestBody Teachers teachers) {
        return teacherService.addTeacher(teachers);
    }

    @PutMapping("/{id}")
    public Teachers updateTeacher(@PathVariable int id, @RequestBody Teachers teachers) {
        return teacherService.updateTeacher(id, teachers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        return teacherService.deleteTeacher(id);
    }
}
