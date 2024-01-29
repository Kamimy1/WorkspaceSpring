package com.terminal_tpv.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.model.Ticket;
import com.terminal_tpv.repository.ProductoRepository;
import com.terminal_tpv.repository.TicketRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@RequestMapping("/")
	public String cargarInicio(HttpSession session, Model model) {
		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		List<Ticket> listaTickets = null;

		try {
			listaTickets = ticketRepository.findAll();
		} catch (Exception e) {

		}

		if (listaTickets.isEmpty()) {
			model.addAttribute("atr_ultimoId", 1);
		} else {
			int ultimoId = ticketRepository.ultimoIDTicket();

			model.addAttribute("atr_ultimoId", ultimoId + 1);
		}

		Enumeration<String> enumerado = session.getAttributeNames();
		List<String> listaDeAtributos = Collections.list(enumerado);
		if (!listaDeAtributos.isEmpty()) {

			List<Map.Entry<Producto, Integer>> listaReal = new ArrayList<>();
			for (String elem : listaDeAtributos) {

				Producto p = productoRepository.getById(Integer.parseInt(elem));
				int cantidad = (int) session.getAttribute(elem);
				listaReal.add(new SimpleEntry<>(p, cantidad));
			}

			model.addAttribute("atr_datos_en_sesion", listaReal);

		}

		return "home_tpv";
	}

}
