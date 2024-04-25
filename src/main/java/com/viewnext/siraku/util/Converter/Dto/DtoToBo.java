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
public class DtoToBo {
	@Autowired
	ModelMapper mapper;

	public ComercialBo comercialDtoToBo(ComercialDto comercialDto) {
		ComercialBo comercialBo = mapper.map(comercialDto, ComercialBo.class);
		return comercialBo;
	}
	
	public ClienteBo clienteDtoToBo(ClienteDto clienteDto) {
		ClienteBo clienteBo = mapper.map(clienteDto, ClienteBo.class);
		return clienteBo;
	}
	
	public ProductoBo productoDtoToBo(ProductoDto productoDto) {
		ProductoBo productoBo = mapper.map(productoDto, ProductoBo.class);
		return productoBo;
	}
}
