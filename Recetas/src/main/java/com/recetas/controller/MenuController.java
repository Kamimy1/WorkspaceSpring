package com.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.model.Dificultad;
import com.recetas.model.Receta;
import com.recetas.repository.DificultadesRepository;
import com.recetas.repository.RecetasRepository;
import com.recetas.service.DificultadesService;

@Controller
public class MenuController {

	@Autowired
	private DificultadesService dificultadService;
	
	@Autowired
	private RecetasRepository recetasRepo;
	
	@Autowired
	private DificultadesRepository dificultadRepo;

	@RequestMapping("/menu_inicio")
	public String menu_inicio(Model model) {

		List<Dificultad> dificultades = dificultadService.obtenerTodasLasDificultades();

		model.addAttribute("atr_dificultades", dificultades);

		return "home";
	}

	@RequestMapping("/menu_mostrar")
	public String menu_mostrar(Model model) {
		
		List<Receta> listaRecetas = recetasRepo.findAll();
		List<Dificultad> listaDificultades= dificultadRepo.findAll();


		model.addAttribute("atr_lista_recetas", listaRecetas);
		model.addAttribute("atr_lista_dificultades", listaDificultades);

		return "mostrar";
	}

}
