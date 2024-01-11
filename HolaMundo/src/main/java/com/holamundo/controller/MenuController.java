package com.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/menu_inicio")
	public String menu_inicio() {
		
		return "home";
	}
	
	@RequestMapping("/menu_cartas")
	public String menu_cartas() {
		
		return "cartas";
	}
	
	@RequestMapping("/menu_figuras")
	public String menu_figuras() {
		
		return "figuras";
	}
	
	@RequestMapping("/menu_mesa")
	public String menu_mesa() {
		
		return "mesa";
	}
	
	@RequestMapping("/menu_rol")
	public String menu_rol() {
		
		return "rol";
	}

}
