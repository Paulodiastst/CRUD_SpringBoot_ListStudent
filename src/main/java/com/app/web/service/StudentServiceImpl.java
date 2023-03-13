package com.app.web.service;

import com.app.web.entity.Student;
import com.app.web.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> listAllStudents() {

        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        return repository.save(student);
    }

    @Override
    public Student callStudentPorId(Long id) {

        return repository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {

        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
