package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student, String teacher)
    {
        studentRepository.addStudentTeacherPair(student, teacher);
    }
    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String teacher)
    {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents()
    {
        return studentRepository.getAllStudent();
    }

    public void deleteTeacherByName(String teacher)
    {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }
}
