package com.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetas.model.Dificultad;

@Repository
public interface DificultadesRepository  extends JpaRepository<Dificultad, Integer> {

}
