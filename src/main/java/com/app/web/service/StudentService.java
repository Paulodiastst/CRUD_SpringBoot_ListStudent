package com.app.web.service;

import com.app.web.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> listAllStudents();

    public Student saveStudent(Student student);

    public Student callStudentPorId(Long id);

    public Student updateStudent(Student student);

    public void deleteStudent(Long id);

}
