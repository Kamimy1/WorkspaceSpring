package com.holamundo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.holamundo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query(value = "SELECT * FROM productos where categoria_id=:valor;", nativeQuery = true)
	 List<Producto> obtenerProductosPorCategoria(@Param("valor") String valor);

}
