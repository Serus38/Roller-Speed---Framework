package com.rollerspeed.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;


@Controller 
@RequestMapping(value = "/index")   
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/mision")
    public String mision(Model model) {
        model.addAttribute("title", "Misión - RollerSpeed");
        model.addAttribute("content", "Nuestra misión es promover el patinaje como un estilo de vida saludable y divertido.");
        return "mision"; // Devuelve la vista "mision.html"
    }

    @GetMapping("/vision")
    public String vision(Model model) {
        model.addAttribute("title", "Visión - RollerSpeed");
        model.addAttribute("content", "Ser la principal referencia en el mundo del patinaje.");
        return "vision"; // Devuelve la vista "vision.html"
    }

    @GetMapping("/valores")
    public String valores(Model model) {
        model.addAttribute("title", "Valores - RollerSpeed");
        model.addAttribute("values", new String[] {
            "Pasión: Amamos lo que hacemos.",
            "Comunidad: Fomentamos un ambiente inclusivo.",
            "Innovación: Buscamos constantemente mejorar.",
            "Responsabilidad: Nos comprometemos con la seguridad."
        });
        return "valores"; // Devuelve la vista "valores.html"
    }

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("title", "Servicios - RollerSpeed");
        model.addAttribute("services", new String[] {
            "Clases de patinaje para todas las edades.",
            "Alquiler de patines de alta calidad.",
            "Eventos personalizados para grupos.",
            "Venta de accesorios y equipos."
        });
        return "servicios"; // Devuelve la vista "servicios.html"
    }

    @GetMapping("/eventos")
    public String eventos(Model model) {
        model.addAttribute("title", "Eventos - RollerSpeed");
        model.addAttribute("events", new String[] {
            "Maratón de patinaje: 15 de noviembre.",
            "Talleres para principiantes: Todos los sábados.",
            "Competencias locales: Amistosas y divertidas.",
            "Noche de patinaje libre: Todos los viernes."
        });
        return "eventos"; // Devuelve la vista "eventos.html"
    }

    @GetMapping("/nuevostudents")
    public String inscribirstudents(Model model) {
        model.addAttribute("title", "Inscribirse - RollerSpeed");
        return "nuevostudents"; // Devuelve la vista "inscribirstudents.html"
    }
}   