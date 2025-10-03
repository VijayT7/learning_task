package com.t7solution.databaseCrud.services;

import com.t7solution.databaseCrud.model.Student;
import com.t7solution.databaseCrud.model.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
    List<StudentDTO> getAllStudents();
    Optional<StudentDTO> getStudentById(int id);
    StudentDTO saveStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(int id, StudentDTO studentDTO);
    void deleteStudent(int id);
}
