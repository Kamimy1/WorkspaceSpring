package com.recetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetas.model.Dificultades;
import com.recetas.repository.DificultadesRepository;

@Service
public class DificultadesService {

	@Autowired
	private DificultadesRepository dificultadRepository; // Asumiendo que tienes un repositorio para las dificultades

	public List<Dificultades> obtenerTodasLasDificultades() {
		return dificultadRepository.findAll();
	}

}
