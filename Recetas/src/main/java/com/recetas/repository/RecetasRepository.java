package com.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetas.model.Receta;

@Repository
public interface RecetasRepository  extends JpaRepository<Receta, Integer> {

}
