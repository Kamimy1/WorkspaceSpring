package com.AMBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMBM.model.Provincia;
import com.AMBM.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	
	@Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }
    
    public Provincia getProvinciaById(Long id) {
        return provinciaRepository.findById(id.intValue()).orElse(null);
    }

}
