package com.terminal_tpv.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.model.TicketInfo;
import com.terminal_tpv.model.TicketProducto;
import com.terminal_tpv.repository.ProductoRepository;
import com.terminal_tpv.repository.TicketProductoRepository;
import com.terminal_tpv.repository.TicketRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private TicketProductoRepository ticketProductoRepo;

	@RequestMapping("/menu_inicio")
	public String menu_inicio(Model model) {

		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		return "redirect:/";
	}

	@RequestMapping("/tickets")
	public String menu_tickets(Model model) {

		List<TicketProducto> listaTicketProductos = ticketProductoRepo.findAll();

		System.out.println(listaTicketProductos);

		Map<Integer, TicketInfo> ticketInfoMap = new HashMap<>();

		for (TicketProducto ticketProducto : listaTicketProductos) {
			int ticketId = ticketProducto.getTicket().getId();
			String fecha = ticketProducto.getTicket().getFecha();
			String hora = ticketProducto.getTicket().getHora();
			String nombreProducto = ticketProducto.getProducto().getNombre();
			int cantidad = ticketProducto.getCantidad();

			if (ticketInfoMap.containsKey(ticketId)) {
				TicketInfo ticketInfo = ticketInfoMap.get(ticketId);
				ticketInfo.agregarProducto(nombreProducto, cantidad);
			} else {
				TicketInfo ticketInfo = new TicketInfo(ticketId, fecha, hora);
				ticketInfo.agregarProducto(nombreProducto, cantidad);
				ticketInfoMap.put(ticketId, ticketInfo);
			}
		}

		model.addAttribute("atr_lista_tickets", new ArrayList<>(ticketInfoMap.values()));

		return "tickets";
	}

	@RequestMapping("/productos")
	public String menu_productos(Model model) {

		List<Producto> listaProductos = productoRepository.findAll();

		model.addAttribute("atr_lista_productos", listaProductos);

		return "productos";
	}

}
