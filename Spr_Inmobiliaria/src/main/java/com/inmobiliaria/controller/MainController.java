package com.inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmobiliaria.model.Vivienda;
import com.inmobiliaria.repository.ViviendaRepository;


@Controller
public class MainController {
	
	@Autowired
    private ViviendaRepository viviendaRepository;
	
	@RequestMapping("/")
	public String cargarInicio(Model model) {
		
		List<Vivienda> viviendas = viviendaRepository.obtenerViviendasCategoria(1);

        model.addAttribute("atr_viviendas", viviendas);
		
		
		return "ventas";
	}

}
