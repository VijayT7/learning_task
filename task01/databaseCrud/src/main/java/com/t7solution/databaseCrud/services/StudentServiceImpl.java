package com.t7solution.databaseCrud.services;

import com.t7solution.databaseCrud.model.Student;
import com.t7solution.databaseCrud.model.StudentDTO;
import com.t7solution.databaseCrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServices {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> s = studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return s;
    }

    @Override
    public Optional<StudentDTO> getStudentById(int id) {
        return studentRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDTO.name());
        student.setEmail(studentDTO.email());
        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    // convertToDTO: Converts a Product entity into a ProductDTO.
    private StudentDTO convertToDTO(Student student){
        StudentDTO s = new StudentDTO(student.getId(), student.getName(), student.getEmail());
        return s;
    }

    // convertToEntity: Converts a ProductDTO into a Product entity.
    private Student convertToEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.name());
        student.setEmail(studentDTO.email());
        return student;
    }


}
