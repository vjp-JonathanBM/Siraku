package com.viewnext.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.repository.ComercialRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class ComercialServicesImplTest {
	private Comercial comercial, comercial2, comercial3;
	private ComercialBo comercialBo, comercialBo2, comercialBo3;
	@Mock
	ComercialRepository comercialRepository;

	@Mock
	EntityToBo entityToBo;

	@Mock
	BoToEntity boToEntity;

	@InjectMocks
	ComercialServicesImpl comercialServicesImpl;

	/*
	 * ===PATRÓN AAA - UNIT TESTING=== Arrange (Inicializar) - Inicializa objetos y
	 * establece el valor de los datos Act (Actuar) - Realiza la llamada al método
	 * Assert (Comprobar)- Comprueba que el metodo realiza las funciones tal y como
	 * tenemos previsto.
	 */

	private void initMocks() {
		comercial = new Comercial();
		comercial.setCodigo(100L);
		comercial.setNombre("Andrea");
		comercial.setApellido1("Sierra");
		comercial.setApellido2("Rodríguez");

		comercial2 = new Comercial();
		comercial2.setCodigo(200L);
		comercial2.setNombre("Mario");
		comercial2.setApellido1("Sánchez");
		comercial2.setApellido2("Pilar");

		comercial3 = new Comercial();
		comercial3.setCodigo(300L);
		comercial3.setNombre("Francisco");
		comercial3.setApellido1("Balonero");
		comercial3.setApellido2("Pilar");

		comercialBo = new ComercialBo(); 
		comercialBo.setCodigo(100L);
		comercialBo.setNombre("Andrea");
		comercialBo.setApellido1("Sierra");
		comercialBo.setApellido2("Rodríguez");

		comercialBo2 = new ComercialBo();
		comercialBo2.setCodigo(200L);
		comercialBo2.setNombre("Mario");
		comercialBo2.setApellido1("Sánchez");
		comercialBo2.setApellido2("Pilar");

		comercialBo3 = new ComercialBo();
		comercialBo3.setCodigo(300L);
		comercialBo3.setNombre("Francisco");
		comercialBo3.setApellido1("Balonero");
		comercialBo3.setApellido2("Pilar");
	}

	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void testCreate() {
		// Arrange
		when(comercialRepository.save(comercial2)).thenReturn(comercial2);
		when(entityToBo.comercialToBo(comercial2)).thenReturn(comercialBo2);
		when(boToEntity.comercialBoTocomercial(comercialBo2)).thenReturn(comercial2);
		//Act
		ComercialBo comercialBoTest = comercialServicesImpl.create(comercialBo2);
		//Assert
		assertNotNull(comercialBoTest);
		assertEquals(200L, comercialBoTest.getCodigo());
		assertEquals("Mario", comercialBoTest.getNombre());
		assertEquals("Sánchez", comercialBoTest.getApellido1());
		assertEquals("Pilar", comercialBoTest.getApellido2());
	}

	@Test
	void testUpdateComercial() {
		//TODO: Cómo actualizar datos
		// Arrange
		when(comercialRepository.save(comercial2)).thenReturn(comercial2);
		when(entityToBo.comercialToBo(comercial2)).thenReturn(comercialBo2);
		when(boToEntity.comercialBoTocomercial(comercialBo2)).thenReturn(comercial2);
		//Act
		ComercialBo comercialBoTest = comercialServicesImpl.updateComercial(comercialBo2);
		//Assert
		assertNotNull(comercialBoTest);
		assertEquals(200L, comercialBoTest.getCodigo());
		assertEquals("Mario", comercialBoTest.getNombre());
		assertEquals("Sánchez", comercialBoTest.getApellido1());
		assertEquals("Pilar", comercialBoTest.getApellido2());
	}

	@Test
	void testRead() {
		//Arrange
		
		
		when(comercialRepository.findByCodigo(100L)).thenReturn(Optional.of(comercial));
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		
		System.out.println(comercial);
		
		//Act
		ComercialBo comercialBo2 = comercialServicesImpl.read(100L);
		System.out.println("Comercial BO 2: "+comercialBo2);
		
		//Assert
		//assertThrows(EntityNotFoundException.class, () -> comercialServicesImpl.read(100L));
		assertEquals(100L, comercialBo2.getCodigo());
		assertEquals("Andrea", comercialBo2.getNombre());
		assertEquals("Sierra", comercialBo2.getApellido1());
		assertEquals("Rodríguez", comercialBo2.getApellido2());
		
	}

	@Test
	void testReadNegative() {
		//Arrange
		
		when(comercialRepository.findByCodigo(1L)).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> comercialServicesImpl.read(1L) );
		
	}

	@Test
	void testGetAll() {
		//Arrange
		when(comercialRepository.findAll()).thenReturn(Arrays.asList(comercial,comercial2,comercial3));
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(entityToBo.comercialToBo(comercial2)).thenReturn(comercialBo2);
		when(entityToBo.comercialToBo(comercial3)).thenReturn(comercialBo3);
		//Act
		List<ComercialBo> listaComercialesBo = comercialServicesImpl.getAll();
		//Assert
		assertNotNull(listaComercialesBo);
		assertEquals(3, listaComercialesBo.size());
		assertTrue(listaComercialesBo.contains(comercialBo));
		assertTrue(listaComercialesBo.contains(comercialBo2));
		assertTrue(listaComercialesBo.contains(comercialBo3));
	}

	@Test
	void testGetNumeroTotalComerciales() {
		//Arrange
		when(comercialRepository.count()).thenReturn(20L);
		//Act
		long totalComerciales = comercialServicesImpl.getNumeroTotalComerciales();
		
		//Assert
		assertEquals(20L, totalComerciales);
	}

	@Test
	void testDelete() {
		// Arrange
		// Act
		comercialServicesImpl.delete(100L);
		// Assert
	}

}
