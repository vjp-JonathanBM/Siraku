package com.viewnext.siraku.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.siraku.backend.business.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
