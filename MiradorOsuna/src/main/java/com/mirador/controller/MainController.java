package com.mirador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String cargarInicio(Model model){
		
		return "index";
		
	}
	
	@RequestMapping("/otro")
	public String cargarOtro(Model model){
		
		return "home_mirador_colegiata";
		
	}
	
	@RequestMapping("/otromas")
	public String cargarOtroMas(Model model){
		
		return "prueba3";
		
	}

}
