package com.army.rest;

import com.army.entity.Student;
import com.army.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private IStudentService service;

    public StudentController(IStudentService service)
    {
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student)
    {
       Student createdStudent=service.createStudent(student);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents()
    {
         List<Student> students=service.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id)
    {
        Student student =service.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id , @RequestBody Student student)
    {
       Student updateStudent=service.updateStudent(id , student);
       return  ResponseEntity.status(HttpStatus.OK).body(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id)
    {
        Boolean status=service.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
