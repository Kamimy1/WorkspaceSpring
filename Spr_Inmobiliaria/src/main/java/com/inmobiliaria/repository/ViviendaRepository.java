package com.inmobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inmobiliaria.model.Vivienda;

public interface ViviendaRepository extends JpaRepository<Vivienda, Integer>{
	
	@Query(value = "SELECT * FROM viviendas where fk_categoria=:valor ", nativeQuery = true)
	 List<Vivienda> obtenerViviendasCategoria(@Param("valor") int valor);

}
