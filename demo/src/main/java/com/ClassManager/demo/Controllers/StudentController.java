package com.ClassManager.demo.Controllers;

import com.ClassManager.demo.Models.Students;
import com.ClassManager.demo.Repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Students addStudent(@RequestBody Students students) {
        return studentRepository.save(students);
    }

    @PutMapping("/{id}")
    public Students updateStudent(@PathVariable int id, @RequestBody Students students) {
        students.setId(id);
        return studentRepository.save(students);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
    }
}
