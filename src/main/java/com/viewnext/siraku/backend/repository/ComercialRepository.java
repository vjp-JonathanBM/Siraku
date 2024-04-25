package com.viewnext.siraku.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.viewnext.siraku.backend.business.model.Comercial;
@Repository
public interface ComercialRepository extends JpaRepository<Comercial, Long>{
	Optional<Comercial> findByCodigo(Long codigo);
	
	@Query("SELECT c.nombre, c.apellido1, c.apellido2 FROM Comercial c")
	List<Object[]> getListaDeArrayDeObjetos();
}
