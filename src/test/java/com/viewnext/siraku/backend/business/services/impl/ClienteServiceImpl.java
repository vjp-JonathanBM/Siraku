package com.viewnext.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.model.Cliente;
import com.viewnext.siraku.backend.repository.ClienteRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImpl {
	private Cliente cliente;
	private ClienteBo clienteBo;

	@Mock
	ClienteRepository clienteRepository;

	@Mock
	EntityToBo entityToBo;

	@Mock
	BoToEntity boToEntity;

	@InjectMocks
	ClienteServicesImpl clienteServicesImpl;

	private void initMocks() {
		cliente = new Cliente();
		cliente.setIdentificadorFiscal("abc");
		cliente.setNombre("Andrea");
		cliente.setApellido1("Sierra");
		cliente.setApellido2("Rodríguez");
		cliente.setNombreComercial("Prueba");

		clienteBo = new ClienteBo();
		clienteBo.setIdentificadorFiscal("abc");
		clienteBo.setNombre("Andrea");
		clienteBo.setApellido1("Sierra");
		clienteBo.setApellido2("Rodríguez");
		clienteBo.setNombreComercial("Prueba");

	}

	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void testCreate() {
		// Arrange
		when(clienteRepository.save(cliente)).thenReturn(cliente);
		when(entityToBo.clienteToBo(cliente)).thenReturn(clienteBo);
		when(boToEntity.clienteBoTocliente(clienteBo)).thenReturn(cliente);
		//Act
		ClienteBo clienteBoTest = clienteServicesImpl.create(clienteBo);
		//Assert
		assertNotNull(clienteBoTest);
		assertEquals("abc", clienteBoTest.getIdentificadorFiscal());
		assertEquals("Andrea", clienteBoTest.getNombre());
		assertEquals("Sierra", clienteBoTest.getApellido1());
		assertEquals("Rodríguez", clienteBoTest.getApellido2());
		assertEquals("Prueba", clienteBoTest.getNombreComercial());
		
	}

	@Test
	void testRead() {
		//Arrange
		
		when(clienteRepository.findById("abc")).thenReturn(Optional.of(cliente));
		when(entityToBo.clienteToBo(cliente)).thenReturn(clienteBo);
				
		System.out.println(cliente);
				
		//Act
		ClienteBo clienteBoTest = clienteServicesImpl.read("abc");
		
		//Assert
		assertEquals("abc", clienteBoTest.getIdentificadorFiscal());
		assertEquals("Andrea", clienteBoTest.getNombre());
		assertEquals("Sierra", clienteBoTest.getApellido1());
		assertEquals("Rodríguez", clienteBoTest.getApellido2());
		assertEquals("Prueba", clienteBoTest.getNombreComercial());	
		
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCliente() {
		fail("Not yet implemented");
	}

}
