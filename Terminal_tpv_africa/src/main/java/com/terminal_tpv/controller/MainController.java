package com.terminal_tpv.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private ProductoRepository productoRepository;

	@RequestMapping("/")
	public String cargarInicio(Model model) {
		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		return "home_tpv";

	}
	
	@RequestMapping("/guardarProdSession/{id}")
	public String guardar_prod_session(HttpSession session, @PathVariable Integer id) {
		
	
		
		session.setAttribute("int_id_prod", id);
		
		System.out.println("id: "+id);
		
		int n_id = 0;
		
		if (session.getAttribute("int_id_prod") != null) {
		    n_id = (Integer) session.getAttribute("int_id_prod");
		}
		
		System.out.println("aaaa: "+n_id);

		Enumeration<String> enumerado = session.getAttributeNames();
		List<String> listaDeAtributos = Collections.list(enumerado);
		for (String elemento : listaDeAtributos) {
			System.out.println(elemento);
		}


		return "redirect:/";
	}

}
