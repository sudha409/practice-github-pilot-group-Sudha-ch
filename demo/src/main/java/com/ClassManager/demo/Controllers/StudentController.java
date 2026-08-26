package com.ClassManager.demo.Controllers;

import com.ClassManager.demo.Models.Students;
import com.ClassManager.demo.Repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        return studentRepository.findById(id)
                .<ResponseEntity<?>>map(student ->
                        new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() ->
                        new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Students addStudent(@RequestBody Students students) {
        return studentRepository.save(students);
    }

    @PutMapping("/{id}")
    public Students updateStudent(@PathVariable Integer id, @RequestBody Students students) {
        students.setId(id);
        return studentRepository.save(students);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }
}
