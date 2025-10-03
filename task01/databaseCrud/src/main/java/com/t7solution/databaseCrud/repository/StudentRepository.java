package com.t7solution.databaseCrud.repository;

import com.t7solution.databaseCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
