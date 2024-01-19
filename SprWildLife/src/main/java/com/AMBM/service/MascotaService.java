package com.AMBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMBM.model.Mascota;
import com.AMBM.repository.MascotaRepository;

@Service
public class MascotaService {
	
	@Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }
    
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

}
