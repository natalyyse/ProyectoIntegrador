package com.tecsup.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecsup.model.Bebida;
import com.tecsup.model.Entrada;
import com.tecsup.model.Plato;
import com.tecsup.service.BebidaService;
import com.tecsup.service.EntradaService;
import com.tecsup.service.PlatoService;

import java.util.List;

@Controller
public class CartaController {
    private final EntradaService entradaService;
    private final PlatoService platoService;
    private final BebidaService bebidaService;

    public CartaController(EntradaService entradaService, PlatoService platoService, BebidaService bebidaService) {
        this.entradaService = entradaService;
        this.platoService = platoService;
        this.bebidaService = bebidaService;
    }

    @GetMapping("/carta")
    public String getCarta(Model model) {
        List<Entrada> entradas = entradaService.obtenerEntradas();
        List<Plato> platos = platoService.obtenerPlatos();
        List<Bebida> bebidas = bebidaService.obtenerBebidas();
        model.addAttribute("entradas", entradas);
        model.addAttribute("platos", platos);
        model.addAttribute("bebidas", bebidas);
        return "carta";  
    }
}