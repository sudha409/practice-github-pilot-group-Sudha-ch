package com.ClassManager.demo.Services;

import com.ClassManager.demo.Models.Teachers;
import com.ClassManager.demo.Repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teachers> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teachers> getTeachersBySubject(String subject) {
        return teacherRepository.findBySubject(subject);
    }

    public ResponseEntity<Teachers> getTeacherById(int id) {
        return teacherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Teachers addTeacher(Teachers teachers) {
        return teacherRepository.save(teachers);
    }

    public Teachers updateTeacher(int id, Teachers teachers) {
        teachers.setId(id);
        return teacherRepository.save(teachers);
    }

    public ResponseEntity<Void> deleteTeacher(int id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
