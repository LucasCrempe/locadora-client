package com.cliente.locadora.controllers;

import com.cliente.locadora.models.Locadora;
import com.cliente.locadora.services.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LocadoraController {

    @Autowired
    private LocadoraService locadoraService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("locadoras", locadoraService.findAll());
        return "lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("locadora", new Locadora());
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("locadora", locadoraService.findById(id));
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Locadora locadora) {
        locadoraService.save(locadora);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        locadoraService.delete(id);
        return "redirect:/";
    }
}