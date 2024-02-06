package com.inmobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.model.Vivienda;
import com.inmobiliaria.repository.ViviendaRepository;

@Service
public class ViviendaService {
	
	@Autowired
    private ViviendaRepository viviendaRep;
	
	public List<Vivienda> getAllViviendasAlquiler() {
        return viviendaRep.obtenerViviendasCategoria(1);
    }

}
