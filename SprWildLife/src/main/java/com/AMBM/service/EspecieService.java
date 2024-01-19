package com.AMBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMBM.model.Especie;
import com.AMBM.repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
    private EspecieRepository especieRepository;

    public List<Especie> getAllEspecies() {
        return especieRepository.findAll();
    }
    
    public Especie getEspecieById(Long id) {
        return especieRepository.findById(id.intValue()).orElse(null);
    }

}
