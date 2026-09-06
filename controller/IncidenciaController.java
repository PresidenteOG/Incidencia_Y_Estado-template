package com.example.demo.SpringBootIncidencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.SpringBootIncidencia.service.EstadoService;
import com.example.demo.SpringBootIncidencia.service.IncidenciaService;

import java.util.List;

@Controller
public class IncidenciaController {

    @Autowired
    private IncidenciaService IncidenciaService;

    @Autowired
    private EstadoService EstadoService;

    // List
    @GetMapping("/Incidencia")
    public String listIncidencia(Model model) {
        List<Incidencia> incidencias = IncidenciaService.getAllIssues();
        model.addAttribute("incidencias", incidencias);
        return "Incidencia-list";
    }

    // New
    @GetMapping("/Incidencia-add")
    public String showAddForm(Model model) {
        model.addAttribute("incidencia", new Incidencia());
        model.addAttribute("estados", EstadoService.getAllEstados());
        return "Incidencia-add";
    }

    // Save
    @PostMapping("/Incidencia")
    public String guardar(Incidencia incidencia) {
        IncidenciaService.saveIncidencia(incidencia);
        return "redirect:/Incidencia";
    }

    // Update
    @GetMapping("/Incidencia/updateData/{id}")
    public String update(@PathVariable Long id, Model model) {
        Incidencia incidencia = IncidenciaService.findID(id);
        model.addAttribute("incidencia", incidencia);
        model.addAttribute("estados", EstadoService.getAllEstados());

        return "Incidencia-update";
    }

    // Delete
    @GetMapping("/Incidencia/deleteData/{id}")
    public String delete(@PathVariable Long id) {
        IncidenciaService.deleteIncidencia(id);
        return "redirect:/Incidencia";
    }

    // Login
    @GetMapping("/LoginIncidencia")
    public String mostrarLogin() {
        return "Incidencia-login";
    }

    @PostMapping("/Incidencia/login")
    public String postlogin(
            @RequestParam(name = "Name") String Name,
            @RequestParam(name = "Password") String Pass,
            Model model) {
        String Checkup = IncidenciaService.Check(Name, Pass);
        return Checkup;
    }

}
