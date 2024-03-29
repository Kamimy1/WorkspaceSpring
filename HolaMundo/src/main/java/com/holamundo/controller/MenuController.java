package com.holamundo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holamundo.model.Producto;
import com.holamundo.repository.ProductoRepository;

@Controller
public class MenuController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@RequestMapping("/menu_inicio")
	public String menu_inicio(Model model) {
		
		List<Producto> listaProductos = productoRepo.findAll();
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		return "home";
	}
	
	@RequestMapping("/menu_cartas")
	public String menu_cartas(Model model) {
		
		List<Producto> listaProductos = productoRepo.obtenerProductosPorCategoria(1);
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		return "cartas";
	}
	
	@RequestMapping("/menu_figuras")
	public String menu_figuras(Model model) {
		
		List<Producto> listaProductos = productoRepo.obtenerProductosPorCategoria(3);
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		return "figuras";
	}
	
	@RequestMapping("/menu_mesa")
	public String menu_mesa(Model model) {
		
		List<Producto> listaProductos = productoRepo.obtenerProductosPorCategoria(2);
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		return "mesa";
	}
	
	@RequestMapping("/menu_rol")
	public String menu_rol(Model model) {
		
		List<Producto> listaProductos = productoRepo.obtenerProductosPorCategoria(4);
		
		model.addAttribute("atr_lista_productos", listaProductos);
		
		return "rol";
	}

}
