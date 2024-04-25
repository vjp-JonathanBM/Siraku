package com.viewnext.siraku.backend.bussiness.Dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viewnext.siraku.backend.business.services.impl.ComercialServicesImpl;
import com.viewnext.siraku.backend.presentation.dto.ComercialDtoAux;
import com.viewnext.siraku.backend.repository.ComercialRepository;
@ExtendWith(MockitoExtension.class)
class ComercialServicesImplTestDto {
	@Mock
	ComercialRepository comercialRepository;
	
	@InjectMocks
	ComercialServicesImpl comercialServicesImpl;
	private void initMocks() {
		
	}
	@BeforeEach
	private void init() {
		

	}
	
	@Test
	void testGetComercialesDtoAux() {
			//Arrange
			List<Object[]> listaObjetos = new ArrayList<>();
			Object[]  fila1 = new Object[] {"Andrea","Sierra","Rodríguez"};
			Object[]  fila2 = new Object[] {"Mario","Sánchez","Pilar"};
			Object[]  fila3 = new Object[] {"Fran","Balonero","Pilar"};
				
			listaObjetos.add(fila1);
			listaObjetos.add(fila2);
			listaObjetos.add(fila3);
				
			when(comercialRepository.getListaDeArrayDeObjetos()).thenReturn(listaObjetos);
			//Act
			List<ComercialDtoAux> lista = comercialServicesImpl.getComercialesDtoAux();
				
			//Assert
			
			assertNotNull(lista);
			assertEquals(3, lista.size());
			List<String>codigo = lista.stream().map(x -> x.getNombre()).toList();
			List<String>nombreCompletoList = lista.stream().map(x -> x.getNombreCompleto()).toList();
			assertTrue(codigo.contains("Andrea"));
			assertTrue(codigo.contains("Mario"));
			assertTrue(codigo.contains("Fran"));
			assertTrue(nombreCompletoList.contains("Sierra"+" "+"Rodríguez"+", "+"Andrea"));
	}

}
