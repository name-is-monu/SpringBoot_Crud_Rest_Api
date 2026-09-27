package com.army.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name Can't be Blank")
    private String name;

    @NotNull(message = "Age can't be null")
    @Min(value = 1 , message = "Age can be 1 to 60")
    @Max(value = 60 , message = "Age can be 1 to 60")
    private Integer age;

    @NotBlank(message = "Email Can't blank")
    @Email(message = "Please Enter a valid email address")
    private String email;

    @NotBlank(message = "Course Can't be blank")
    private String course;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
       this.course = course;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", Course='" + course + '\'' +
                '}';
    }
}
