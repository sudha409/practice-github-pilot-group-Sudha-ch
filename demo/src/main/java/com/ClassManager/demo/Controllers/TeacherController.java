package com.ClassManager.demo.Controllers;

import com.ClassManager.demo.Models.Students;
import com.ClassManager.demo.Models.Teachers;
import com.ClassManager.demo.Repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teachers> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getTeacherById(@PathVariable int id) {
        return teacherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teachers addTeacher(@RequestBody Teachers teachers) {
        return teacherRepository.save(teachers);
    }

    @PutMapping("/{id}")
    public Teachers updateTeacher(@PathVariable int id, @RequestBody Teachers teachers) {
        teachers.setId(id);
        return teacherRepository.save(teachers);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
