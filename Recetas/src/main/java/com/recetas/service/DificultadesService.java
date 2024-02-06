package com.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetas.model.Dificultad;
import com.recetas.repository.DificultadesRepository;

@Service
public class DificultadesService {

	@Autowired
	private DificultadesRepository dificultadRepository; 

	public List<Dificultad> obtenerTodasLasDificultades() {
		return dificultadRepository.findAll();
	}

}
