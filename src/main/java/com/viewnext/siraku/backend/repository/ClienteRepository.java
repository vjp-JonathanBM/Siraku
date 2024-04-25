package com.viewnext.siraku.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.siraku.backend.business.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
