package com.ClassManager.demo.Repositories;

import com.ClassManager.demo.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Students, Integer> {
}
