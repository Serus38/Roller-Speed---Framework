package com.rollerspeed.v1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.rollerspeed.v1.Model.Student;
import com.rollerspeed.v1.Services.StudentService;


@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/listar")
    public String listStudents(Model model) {
        List<Student> students = studentService.listar();
        model.addAttribute("students", students);
        return "students/listarstudents";
    }
}


