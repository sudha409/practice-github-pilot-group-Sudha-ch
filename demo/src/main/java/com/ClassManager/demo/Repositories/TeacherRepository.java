package com.ClassManager.demo.Repositories;

import com.ClassManager.demo.Models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
    List<Teachers> findBySubject(String subject);
}
