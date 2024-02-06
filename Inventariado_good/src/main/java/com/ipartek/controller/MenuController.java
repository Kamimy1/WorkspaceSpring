package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Producto;
import com.ipartek.repository.InventarioRepository;
import com.ipartek.repository.ProductoRepository;

@Controller
public class MenuController {

	@ Autowired
	private InventarioRepository inventarioRepo;
	
	@RequestMapping("/menu_inventario")
	public String menuInventario() {
		return "redirect:/";
	}

	@RequestMapping("/menu_detalles")
	public String menuDetalles(Model model) {
		
		model.addAttribute("atr_lista_productos", inventarioRepo.findAll());
		
		return "detalles";
	}

}
