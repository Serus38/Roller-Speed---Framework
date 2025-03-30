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

import com.rollerspeed.v1.Model.Teacher;
import com.rollerspeed.v1.Services.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(value = "/teachers")
@Tag(name = "TeacherController", description = "Controlador de profesores")
public class TeacherController {
    
    @Autowired  
    TeacherService teacherService;

    @GetMapping("/listar")
    @Operation(summary = "Listar profesores", description = "Lista todos los profesores registrados")
    public String listTeachers(Model model) {
        List<Teacher> teachers = teacherService.listar();
        model.addAttribute("teachers", teachers);
        return "teachers/listarteachers";
    }

    @GetMapping("/nuevo")
    @Operation(summary = "Nuevo profesor", description = "Crea un nuevo profesor")
    public String newTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/nuevoteachers";
    }

    @PostMapping("/guardar")
    @Operation(summary = "Guardar profesor", description = "Guarda un nuevo profesor o actualiza uno existente")
    public String saveTeacher(@ModelAttribute Teacher teacher,
                             BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()){
            return "teachers/nuevoteachers";
        }
        teacherService.save(teacher);
        redirectAttrs.addFlashAttribute("mensaje", "Registro guardado");
        return "redirect:/teachers/listar";
    }

    @GetMapping("/edit/{id}")
    @Operation(summary = "Editar profesor", description = "Edita un profesor por su ID")
    public String editTeacher(@PathVariable Long id, Model model) {
        Teacher teacher = teacherService.get(id);
        model.addAttribute("teacher", teacher);
        return "teachers/nuevoteachers";
    }

    @GetMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar profesor", description = "Elimina un profesor existente")
    public String deleteTeacher(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        teacherService.delete(id);
        redirectAttrs.addFlashAttribute("mensaje", "Registro eliminado");
        return "redirect:/teachers/listar";
    }
}
