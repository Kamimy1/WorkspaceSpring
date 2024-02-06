package com.recetas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.model.Dificultad;
import com.recetas.service.DificultadesService;

@Controller
public class MainController {
	
	@Autowired
    private DificultadesService dificultadService;
	
	@RequestMapping("/")
	public String cargarInicio(Model model) {
		
		List<Dificultad> dificultades = dificultadService.obtenerTodasLasDificultades();

        model.addAttribute("atr_dificultades", dificultades);
		
		
		return "home";
	}

}
