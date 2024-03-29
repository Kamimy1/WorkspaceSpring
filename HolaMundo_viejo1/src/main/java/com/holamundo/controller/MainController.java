package com.holamundo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holamundo.model.Producto;
import com.holamundo.repository.ProductoRepository;

@Controller
public class MainController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@RequestMapping("/")
	public String cargarInicio(Model model){
		
		List<Producto> listaProductos = productoRepo.findAll();
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		for(Producto prod : listaProductos ) {
			System.out.println(prod);
		}
		
		return "home";
		
	}

}
