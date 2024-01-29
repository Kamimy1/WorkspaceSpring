package com.terminal_tpv.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terminal_tpv.model.Producto;
import com.terminal_tpv.model.Ticket;
import com.terminal_tpv.model.TicketInfo;
import com.terminal_tpv.model.TicketProducto;
import com.terminal_tpv.repository.ProductoRepository;
import com.terminal_tpv.repository.TicketProductoRepository;
import com.terminal_tpv.repository.TicketRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class TicketController {

	@Autowired
	private ProductoRepository productoRepo;

	@Autowired
	private TicketRepository ticketRepo;

	@Autowired
	private TicketProductoRepository ticketProductoRepo;

	@RequestMapping("/agregarAlTicket/{id}")
	public String GestionarTicket(@PathVariable int id, HttpSession session) {

		String identificador = "" + id;

		if (session.getAttribute(identificador) != null) {
			session.setAttribute(identificador, (int) session.getAttribute(identificador) + 1);
		}

		else {
			session.setAttribute(identificador, 1);
		}

		Enumeration<String> enumerado = session.getAttributeNames();
		List<String> listaDeAtributos = Collections.list(enumerado);
		for (String elemento : listaDeAtributos) {
			System.out.print(elemento);
			System.out.println(session.getAttribute(elemento));
		}

		return "redirect:/";
	}

	@RequestMapping("/cancelarTicket")
	public String cancelarTicket(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping("/agregarTicket")
	public String agregarTicket(HttpSession session) {
		Ticket ti = new Ticket();

		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		String fechaFormateada = formato.format(fecha);

		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
		String horaFormateada = formatoHora.format(fecha);

		ti.setFecha(fechaFormateada);
		ti.setHora(horaFormateada);

		System.out.println(ti);

		Ticket ticketInsertado = ticketRepo.save(ti);

		System.out.println("TICKET: " + ticketInsertado);

		Enumeration<String> enumerado = session.getAttributeNames();
		List<String> listaDeAtributos = Collections.list(enumerado);

		List<TicketProducto> ListaTicketProd = new ArrayList<>();

		if (!listaDeAtributos.isEmpty()) {

			for (String elem : listaDeAtributos) {

				Producto p = productoRepo.getById(Integer.parseInt(elem));

				int cantidad = (int) session.getAttribute(elem);

				ListaTicketProd.add(new TicketProducto(ticketInsertado, p, cantidad));
			}

			for (TicketProducto ticketProducto : ListaTicketProd) {
				ticketProductoRepo.save(ticketProducto);
			}

			session.invalidate();
		}

		return "redirect:/";
	}

}
