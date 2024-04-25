package com.viewnext.siraku.backend.presentation.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.siraku.backend.business.bo.ProductoBo;
import com.viewnext.siraku.backend.business.services.ProductoServices;
import com.viewnext.siraku.backend.presentation.dto.ProductoDto;
import com.viewnext.siraku.util.Converter.Dto.BoToDto;
import com.viewnext.siraku.util.Converter.Dto.DtoToBo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/producto")
@RestController
public class ProductoController {

	@Autowired
	private ProductoServices productoServices;

	@Autowired
	private DtoToBo dtoToBo;

	@Autowired
	private BoToDto boToDto;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductoDto>> getProducto() {
		try {
			List<ProductoBo> productoBo = productoServices.getAll();
			System.out.println(productoBo);
			List<ProductoDto> productoDto = productoBo.stream().map(boToDto::productoBoToProductoDto)
					.collect(Collectors.toList());
			System.out.println(productoDto);
			log.info("Obteniendo lista de productos");
			return ResponseEntity.ok(productoDto);
		} catch (ServiceException se) {
			log.error("Error al obtener la lista de productos");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	

}
