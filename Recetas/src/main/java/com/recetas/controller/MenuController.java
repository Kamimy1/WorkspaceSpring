package com.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.model.Dificultades;
import com.recetas.service.DificultadesService;

@Controller
public class MenuController {

	@Autowired
	private DificultadesService dificultadService;

	@RequestMapping("/menu_inicio")
	public String menu_inicio(Model model) {

		List<Dificultades> dificultades = dificultadService.obtenerTodasLasDificultades();

		// Pasar las dificultades al modelo
		model.addAttribute("atr_dificultades", dificultades);

		return "home";
	}

	@RequestMapping("/menu_mostrar")
	public String menu_mostrar(Model model) {

		return "home";
	}

}
