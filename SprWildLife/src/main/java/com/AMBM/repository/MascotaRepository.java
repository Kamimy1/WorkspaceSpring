package com.AMBM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AMBM.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

	@Query(value = "SELECT * FROM mascotas where Especie_id=:valor ", nativeQuery = true)
	 List<Mascota> obtenerProductosPorEspecie(@Param("valor") int valor);

}
