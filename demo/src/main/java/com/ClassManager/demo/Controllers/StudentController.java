package com.ClassManager.demo.Controllers;

import com.ClassManager.demo.Models.Students;
import com.ClassManager.demo.Repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable int id) {
        return studentRepository.findById(id).toString();
    }
}
