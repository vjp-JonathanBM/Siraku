package com.viewnext.siraku.backend.bussiness.Dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.model.Cliente;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.business.services.ComercialServices;
import com.viewnext.siraku.backend.business.services.impl.ComercialServicesImpl;
import com.viewnext.siraku.backend.presentation.dto.ClienteDto;
import com.viewnext.siraku.backend.presentation.dto.ComercialDto;
import com.viewnext.siraku.backend.repository.ComercialRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;
import com.viewnext.siraku.util.Converter.Dto.BoToDto;
import com.viewnext.siraku.util.Converter.Dto.DtoToBo;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ComercialMapDtoTest {

	@Mock
	ComercialRepository comercialRepository;
	
	@Mock
	EntityToBo entityToBo;

	@Mock
	BoToEntity boToEntity;
	
	@Mock
	BoToDto boToDto;
	
	@Mock
	DtoToBo dtoToBo;
	

	@InjectMocks
	private ComercialServicesImpl comercialServicesImpl;

	
	
	private ComercialDto comercialDto;
	private ComercialDto comercialDtoUpdate;
	private ComercialBo comercialBo;
	private ComercialBo comercialBoUpdate;
	private Comercial comercial;
	
	private Optional<Comercial> comercialOpt;
	
	private void initMocks() {
		comercial = new Comercial();
		comercial.setCodigo(1L);
		comercial.setNombre("Andrea");
		comercial.setApellido1("Sierra");
		comercial.setApellido2("Rodríguez");

		
		comercialDto = new ComercialDto();
		comercialDto.setCodigo(1L);
		comercialDto.setNombre("Andrea");
		comercialDto.setApellido1("Sierra");
		comercialDto.setApellido2("Rodríguez");

		comercialDtoUpdate = new ComercialDto();
		comercialDtoUpdate.setCodigo(1L);
		comercialDtoUpdate.setNombre("updaten");
		comercialDtoUpdate.setApellido1("ape1");
		comercialDtoUpdate.setApellido2("ape2");

		
		comercialBo = new ComercialBo();
		comercialBo.setCodigo(1L);
		comercialBo.setNombre("Andrea");
		comercialBo.setApellido1("Sierra");
		comercialBo.setApellido2("Rodríguez");
		
		comercialBoUpdate = new ComercialBo();
		comercialBoUpdate.setCodigo(1L);
	}

	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void testGetComercial() {
		//Arrange
		when(comercialRepository.findAll()).thenReturn(Arrays.asList(comercial));
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		//Act
		List<ComercialBo> listaComercialesBo = comercialServicesImpl.getAll();
		ComercialDto comercialDtoTest = boToDto.comercialBoTocomercialDto(comercialBo);
		List<ComercialDto> listaComercialesDto = new ArrayList<>();
		listaComercialesDto.add(comercialDtoTest);
		//Assert
		assertNotNull(listaComercialesDto);
		assertEquals(1, listaComercialesDto.size());
		assertTrue(listaComercialesDto.contains(comercialDtoTest));
	}
	
	@Test
	void TestGetComercialByCodigo() {
		//Arrange
		when(comercialRepository.findByCodigo(1L)).thenReturn(Optional.of(comercial));
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(boToDto.comercialBoTocomercialDto(comercialBo)).thenReturn(comercialDto);
		//Act
		ComercialBo comercialBoTest = comercialServicesImpl.read(1L);
		ComercialDto comercialDtoTest = boToDto.comercialBoTocomercialDto(comercialBoTest);
		
		//Assert
		assertEquals(1L, comercialDtoTest.getCodigo());
		assertEquals("Andrea", comercialDtoTest.getNombre());
		assertEquals("Sierra", comercialDtoTest.getApellido1());
		assertEquals("Rodríguez", comercialDtoTest.getApellido2());	
	}
	
	@Test
	void testReadNegative() {
		//Arrange
		when(comercialRepository.findByCodigo(1L)).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> comercialServicesImpl.read(1L) );	
	}
	
	@Test
	void testCreate() {
		// Arrange
		when(comercialRepository.save(comercial)).thenReturn(comercial);
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(boToEntity.comercialBoTocomercial(comercialBo)).thenReturn(comercial);
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(boToDto.comercialBoTocomercialDto(comercialBo)).thenReturn(comercialDto);
		//Act
		ComercialBo comercialBoTest = comercialServicesImpl.create(comercialBo);
		ComercialDto comercialDtoTest = boToDto.comercialBoTocomercialDto(comercialBoTest);
		//Assert
		assertEquals(1L, comercialDtoTest.getCodigo());
		assertEquals("Andrea", comercialDtoTest.getNombre());
		assertEquals("Sierra", comercialDtoTest.getApellido1());
		assertEquals("Rodríguez", comercialDtoTest.getApellido2());
	}
	
	@Test
	void testDelete() {
		// Arrange
		// Act
		comercialServicesImpl.delete(1L);
		// Assert
	}
	
	@Test
	void testUpdateComercial() {
		//TODO: Cómo actualizar datos
		// Arrange
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(boToEntity.comercialBoTocomercial(comercialBo)).thenReturn(comercial);
		when(boToEntity.comercialBoTocomercial(comercialBo)).thenReturn(comercial);	
		when(comercialRepository.save(comercial)).thenReturn(comercial);
		when(boToDto.comercialBoTocomercialDto(comercialBo)).thenReturn(comercialDtoUpdate);
		
		//Act
		
		comercialBoUpdate = entityToBo.comercialToBo(comercial);
		comercialBo = comercialServicesImpl.updateComercial(comercialBoUpdate);
		ComercialDto comercialDtoUpdated = boToDto.comercialBoTocomercialDto(comercialBo);		
		
		//Assert
		assertNotNull(comercialDtoUpdated);
		assertEquals(1L, comercialDtoUpdated.getCodigo());
		assertEquals("updaten", comercialDtoUpdated.getNombre());
		assertEquals("ape1", comercialDtoUpdated.getApellido1());
		assertEquals("ape2", comercialDtoUpdated.getApellido2());
	}
	
	
}
