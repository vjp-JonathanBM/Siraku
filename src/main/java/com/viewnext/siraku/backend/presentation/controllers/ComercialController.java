package com.viewnext.siraku.backend.presentation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.services.ComercialServices;
import com.viewnext.siraku.backend.presentation.dto.ComercialDto;
import com.viewnext.siraku.backend.presentation.dto.ComercialDtoAux;
import com.viewnext.siraku.util.Converter.Dto.BoToDto;
import com.viewnext.siraku.util.Converter.Dto.DtoToBo;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/comercial")
public class ComercialController { 

	@Autowired
	private ComercialServices comercialServices;
	@Autowired
	private DtoToBo dtoToBo;

	@Autowired
	private BoToDto boToDto;

	@GetMapping("/all")
	public ResponseEntity<List<ComercialDto>> getComercial() {
		try {
			List<ComercialBo> comercialBo = comercialServices.getAll();
			System.out.println(comercialBo);
			List<ComercialDto> comercialDto = comercialBo.stream().map(boToDto::comercialBoTocomercialDto)
					.collect(Collectors.toList());
			System.out.println(comercialDto);
			log.info("Obteniendo lista de comerciales");
			return ResponseEntity.ok(comercialDto);
		} catch (ServiceException se) {
			log.error("Error al obtener la lista de comerciales");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@GetMapping("/allDtoAux")
	public List<ComercialDtoAux> getComercialesDtoAux(){
		return comercialServices.getComercialesDtoAux(); 
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ComercialDto> getComercialByCode(@PathVariable long codigo) {
		try {
			ComercialBo comercialBo = comercialServices.read(codigo);
			ComercialDto comercialDto = boToDto.comercialBoTocomercialDto(comercialBo);
			return ResponseEntity.ok(comercialDto);
		} catch (ServiceException se) {
			log.error("Error de servicio al intentar buscar un comercial por codigo: "+codigo);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException npe) {
			log.error("Error de lectura - codigo "+codigo+" no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<ComercialDto> createComercial(@RequestBody ComercialDto comercialDto) {
		try {
			ComercialBo comercialBo = dtoToBo.comercialDtoToBo(comercialDto);
			comercialServices.create(comercialBo);
			ComercialDto savedComercialDto = boToDto.comercialBoTocomercialDto(comercialBo);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedComercialDto);
		} catch (ServiceException se) {
			log.error("Error de servicio al intentar crear un nuevo comercial");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} 
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ComercialDto> updateComercial(@PathVariable long codigo,
			@RequestBody ComercialDto comercialDto) {
		try {
			ComercialBo comercialBo = dtoToBo.comercialDtoToBo(comercialDto);
			comercialBo = comercialServices.read(codigo);
			comercialBo.setNombre(comercialDto.getNombre());
			comercialBo.setApellido1(comercialDto.getApellido1());
			comercialBo.setApellido2(comercialDto.getApellido2());
			comercialServices.updateComercial(comercialBo);
			ComercialDto updateComercialDto = boToDto.comercialBoTocomercialDto(comercialBo);
			return ResponseEntity.status(HttpStatus.CREATED).body(updateComercialDto);
		} catch (ServiceException e) {
			log.error("Error de servicio al intentar buscar un comercial por codigo: "+codigo);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException npe) {
			log.error("Error de lectura - codigo "+codigo+" no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deleteComercial(@PathVariable long codigo) {
		try {
			comercialServices.delete(codigo);
			return ResponseEntity.ok().build();
		} catch (ServiceException e) {
			log.error("Error de servicio al intentar buscar un comercial por codigo: "+codigo);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException npe) {
			log.error("Error de lectura - codigo "+codigo+" no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
