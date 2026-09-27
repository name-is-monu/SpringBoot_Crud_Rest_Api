package com.army.service;

import com.army.entity.Student;

import java.util.List;

public interface IStudentService
{
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id , Student student);
    Boolean deleteStudent(Long id);
}
