package com.rollerspeed.v1.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.rollerspeed.v1.Model.Student;
import com.rollerspeed.v1.Services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/listar")
    public String listStudents(Model model) {
        List<Student> students = studentService.listar();
        model.addAttribute("students", students);
        return "students/listarstudents";
    }

    @GetMapping("/nuevo")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/nuevostudents";
    }

    @PostMapping("/guardar")
    public String saveStudent(@ModelAttribute Student student,
                            BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()){
            return "students/nuevostudents";
        }
        studentService.save(student);
        redirectAttrs.addFlashAttribute("mensaje", "Registro guardado");
        return "redirect:/students/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        studentService.delete(id);
        redirectAttrs.addFlashAttribute("mensaje", "Registro eliminado");
        return "redirect:/students/listar";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "students/nuevostudents";
    }

    
}


