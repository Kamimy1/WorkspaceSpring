package com.recetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.model.Receta;
import com.recetas.repository.RecetasRepository;

@Controller
public class AdminController {

	@Autowired
	private RecetasRepository recetasRepo;

	@RequestMapping("/guardarReceta")
	public String guardarReceta(@ModelAttribute Receta objeto_entidad) {

		recetasRepo.save(objeto_entidad);
		return "redirect:/";
	}

}
