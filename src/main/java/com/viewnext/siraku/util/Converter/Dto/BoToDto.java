package com.viewnext.siraku.util.Converter.Dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.bo.ProductoBo;
import com.viewnext.siraku.backend.presentation.dto.ClienteDto;
import com.viewnext.siraku.backend.presentation.dto.ComercialDto;
import com.viewnext.siraku.backend.presentation.dto.ProductoDto;

@Component
public class BoToDto {
	@Autowired
	ModelMapper mapper;
	
	public ComercialDto comercialBoTocomercialDto(ComercialBo comercialBo) {
		ComercialDto comercialDto = mapper.map(comercialBo,  ComercialDto.class);
		return comercialDto;
	}
	
	public ClienteDto clienteBoToClienteDto(ClienteBo clienteBo) {
		ClienteDto clienteDto = mapper.map(clienteBo, ClienteDto.class);
		return clienteDto;
	}
	
	public ProductoDto productoBoToProductoDto(ProductoBo productoBo) {
		ProductoDto productoDto = mapper.map(productoBo,  ProductoDto.class);
		return productoDto; 
	}
	
}
