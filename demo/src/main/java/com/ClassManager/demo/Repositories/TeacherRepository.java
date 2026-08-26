package com.ClassManager.demo.Repositories;

import com.ClassManager.demo.Models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
}
