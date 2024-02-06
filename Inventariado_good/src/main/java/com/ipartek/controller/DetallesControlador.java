package com.ipartek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Inventario;

@Controller
public class DetallesControlador {

	
	
	
	@RequestMapping("/detalles_borrar")
	public String detallesBorrar( ) {

		System.out.println("SE HA BORRAU");

		return "redirect:/menu_detalles";
	}
	
	@RequestMapping("/detalles_modificar")
	public String detallesModificar( ) {

		System.out.println("SE HA MODIFICAU");

		return "redirect:/menu_detalles";
	}
	
}
