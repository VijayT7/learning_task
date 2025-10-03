package com.t7solution.databaseCrud.rest;

import com.t7solution.databaseCrud.model.Student;
import com.t7solution.databaseCrud.model.StudentDTO;
import com.t7solution.databaseCrud.services.StudentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        return studentServices.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id){
        Optional<StudentDTO> student = studentServices.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        System.out.println("studentDTO" + studentDTO);
        StudentDTO s = studentServices.saveStudent(studentDTO);
        return s;
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){
        try{
            StudentDTO updatedStudent = studentServices.updateStudent(id, studentDTO);
            return ResponseEntity.ok(updatedStudent);
        }catch(Exception e){
            System.out.println("Exception : " + e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentServices.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
