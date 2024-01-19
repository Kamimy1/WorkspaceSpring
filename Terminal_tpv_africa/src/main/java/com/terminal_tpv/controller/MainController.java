package com.terminal_tpv.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.repository.ProductoRepository;

@Controller
public class MainController {
	
	@Autowired
    private ProductoRepository productoRepository; 

	
	@RequestMapping("/")
	public String cargarInicio(Model model){
		
		List<Producto> listaProductos = productoRepository.findAll();
		
		model.addAttribute("atr_lista_productos", listaProductos);

		return "home_tpv";
		
	}

}
