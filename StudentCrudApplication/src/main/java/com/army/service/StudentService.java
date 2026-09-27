package com.army.service;

import com.army.aspect.ResourceNotFoundException;
import com.army.entity.Student;
import com.army.repo.IStudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService
{
    private IStudentRepo repo;

    public StudentService(IStudentRepo repo)
    {
        this.repo=repo;
    }


    @Override
    public Student createStudent(Student student)
    {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents()
    {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id)
    {
        Student student=repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student Not Found with id :"+id));
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student)
    {
        Student existingStudent =repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student  Not Found With id :"+id));
       existingStudent.setName(student.getName());
       existingStudent.setAge(student.getAge());
       existingStudent.setEmail(student.getEmail());
       existingStudent.setCourse(student.getCourse());
       return  repo.save(existingStudent);

    }

    @Override
    public Boolean deleteStudent(Long id)
    {
        Student deletedStudent =repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student Not Found with id :"+id));
       repo.delete(deletedStudent);
       return true;
    }
}
