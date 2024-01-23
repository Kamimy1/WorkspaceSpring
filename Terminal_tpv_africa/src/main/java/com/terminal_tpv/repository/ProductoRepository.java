package com.terminal_tpv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terminal_tpv.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query(value = "SELECT foto FROM productos where id=:valor ", nativeQuery = true)
	 String obtenerNombreFoto(@Param("valor") int valor);


}
