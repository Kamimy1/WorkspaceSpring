package com.terminal_tpv.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {

	@Autowired
	private ProductoRepository productoRepository;

	@RequestMapping("/menu_inicio")
	public String menu_inicio(Model model) {

		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		return "home_tpv";
	}

	@RequestMapping("/tickets")
	public String menu_tickets(Model model) {

		return "tickets";
	}

	@RequestMapping("/productos")
	public String menu_productos(Model model) {

		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		return "productos";
	}
	
	

}
