package com.viewnext.siraku.backend.presentation.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.services.ClienteServices;
import com.viewnext.siraku.backend.presentation.dto.ClienteDto;
import com.viewnext.siraku.util.Converter.Dto.BoToDto;
import com.viewnext.siraku.util.Converter.Dto.DtoToBo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteServices clienteServices;

	@Autowired
	private DtoToBo dtoToBo;

	@Autowired
	private BoToDto boToDto;
	
	@GetMapping("/all")
	public ResponseEntity<List<ClienteDto>> getCliente() {
		try {
			List<ClienteBo> clienteBo = clienteServices.getAll();
			System.out.println(clienteBo);
			List<ClienteDto> clienteDto = clienteBo.stream().map(boToDto::clienteBoToClienteDto)
					.collect(Collectors.toList());
			System.out.println(clienteDto);
			log.info("Obteniendo lista de clientes");
			return ResponseEntity.ok(clienteDto);
		} catch (ServiceException se) {
			log.error("Error al obtener la lista de clientes");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> getComercialByCode(@PathVariable String id) {
		try {
			ClienteBo clienteBo = clienteServices.read(id);
			ClienteDto clienteDto = boToDto.clienteBoToClienteDto(clienteBo);
			return ResponseEntity.ok(clienteDto);
		} catch (ServiceException se) {
			log.error("Error de servicio al intentar buscar un cliente por codigo: "+id);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException npe) {
			log.error("Error de lectura - cliente "+id+" no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
