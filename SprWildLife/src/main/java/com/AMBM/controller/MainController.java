package com.AMBM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AMBM.model.Mascota;
import com.AMBM.repository.MascotaRepository;


@Controller
public class MainController {
	
	@Autowired
	private MascotaRepository mascotaRepo;
	
	@RequestMapping("/")
	public String cargarInicio(Model model){
		
		List<Mascota> listaMascotas = mascotaRepo.findAll();
		
		model.addAttribute("atr_lista_mascotas", listaMascotas);
		
		for(Mascota masc : listaMascotas) {
			
			System.out.println(masc);
		}
		
		return "home";
		
	}

}
