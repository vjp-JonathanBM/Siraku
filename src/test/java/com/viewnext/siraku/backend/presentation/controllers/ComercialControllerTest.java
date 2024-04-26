package com.viewnext.siraku.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;



import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.business.services.ComercialServices;
import com.viewnext.siraku.backend.business.services.impl.ComercialServicesImpl;
import com.viewnext.siraku.backend.presentation.dto.ComercialDto;
import com.viewnext.siraku.backend.repository.ComercialRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;
import com.viewnext.siraku.util.Converter.Dto.BoToDto;
import com.viewnext.siraku.util.Converter.Dto.DtoToBo;

@WebMvcTest(controllers = ComercialController.class)
public class ComercialControllerTest {

	@MockBean
	ComercialRepository comercialRepository;
	
	@MockBean
	EntityToBo entityToBo;

	@MockBean
	BoToEntity boToEntity;
	
	@MockBean
	BoToDto boToDto;
	
	@MockBean
	DtoToBo dtoToBo;
	

	@InjectMocks
	private ComercialServicesImpl comercialServicesImpl;

	
	@Autowired
	private MockMvc mockMvc; // "aparato" que va a realizar peticiones HTTP y recibir respuestas (es el
								// cliente)

	@Autowired
	private ObjectMapper objectMapper; // "aparato" de Jackson para serializar/deserializar de JSON a Java o viceversa

	@MockBean
	private ComercialServices comercialServices; // servicio "fake"

	private ComercialDto comercialDto;
	private ComercialDto comercialDtoUpdate;
	private ComercialBo comercialBo;
	private ComercialBo comercialBoUpdate;
	private Comercial comercial;
	
	private List<Comercial> lComercial;
	private List<ComercialBo> lComercialBo;
	
	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	public void getComerciales() throws Exception {
		when(comercialRepository.findAll()).thenReturn(lComercial);
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		
		when(comercialServices.getAll()).thenReturn(lComercialBo);
		MvcResult mvcResult = mockMvc.perform(get("/comercial/all").contentType("application/json"))
									 .andExpect(status().isOk())
									 .andReturn();
//		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);	
//		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(lComercial));				
	}

	@Test
	public void cuandoPidoComercialPorCodigo() throws Exception {
		when(comercialServices.read(1L)).thenReturn(comercialBo);
		MvcResult mvcResult = mockMvc.perform(get("/comercial/1").contentType("application/json"))
				 .andExpect(status().isOk())
				 .andReturn();
//		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
//		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(comercial));
	}
	
	@Test
	public void cuandoCreoComercial() throws Exception {
		
		when(comercialRepository.save(comercial)).thenReturn(comercial);
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(boToEntity.comercialBoTocomercial(comercialBo)).thenReturn(comercial);
		
		when(entityToBo.comercialToBo(comercial)).thenReturn(comercialBo);
		when(comercialServices.create(comercialBo)).thenReturn(comercialBo);
		
		when(boToDto.comercialBoTocomercialDto(comercialBo)).thenReturn(comercialDto);
		
		
		
		ResultActions response = mockMvc.perform(post("/comercial/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comercial)));
		
		/* response.andDo(print()).
         andExpect(status().isCreated())
         .andExpect(jsonPath("$.nombre",
                 is(comercial.getNombre())))
         .andExpect(jsonPath("$.apellido1",
                 is(comercial.getApellido1())))
         .andExpect(jsonPath("$.apellido2",
                 is(comercial.getApellido2())));*/
	
	}
	
	
	/**
	 * 
	 * PRIVATE METHODS
	 * 
	 */

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
		
		lComercial = new ArrayList<>();
		lComercialBo = new ArrayList<>();
		
		lComercial.add(comercial);
		lComercialBo.add(comercialBo);
	}

}
