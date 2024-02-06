package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Inventario;
import com.ipartek.repository.InventarioRepository;


@Controller
public class InventarioController {
	
	@Autowired
	private InventarioRepository inventarioRepo;
	
	
	//aqui tendremos el controlador de cuando pulsemos el boton submit
	@RequestMapping("/actualizar_cantidad")
	public String menuInventario(@ModelAttribute Inventario objeto_entidad) {
		
		
		//hacer cosas
		System.out.println("ENTRA A ACTUALIZAR");
		
		System.out.println(objeto_entidad);
		
		inventarioRepo.save(objeto_entidad);
		
		
		
		
		
		
		return "redirect:/";
	}
	

}
