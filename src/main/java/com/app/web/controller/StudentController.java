package com.app.web.controller;

import com.app.web.entity.Student;
import com.app.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping({"/students", "/"})
    public String listStudents(Model modelo) {
        modelo.addAttribute("students", service.listAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String showFormDeRegisterStudent(Model modelo) {
        Student student = new Student();
        modelo.addAttribute("student", student);
        return "new_students";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String showFormDeEdit(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("student", service.callStudentPorId(id));
        return "update_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model modelo) {
        Student studentExisting = service.callStudentPorId(id);
        studentExisting.setId(id);
        studentExisting.setName(student.getName());
        studentExisting.setSurname(student.getSurname());
        studentExisting.setEmail(student.getEmail());

        service.updateStudent(studentExisting);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
