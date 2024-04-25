package com.viewnext.siraku.util.Converter.Bo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.bo.ProductoBo;
import com.viewnext.siraku.backend.business.model.Cliente;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.business.model.Producto;
@Component
public class EntityToBo {
	@Autowired
	ModelMapper mapper;

	public ComercialBo comercialToBo(Comercial comercial) {
		ComercialBo comercialBo = mapper.map(comercial, ComercialBo.class);
		return comercialBo;
	}
	
	public ClienteBo clienteToBo(Cliente cliente) {
		ClienteBo clienteBo = mapper.map(cliente, ClienteBo.class);
		return clienteBo;
	}
	
	public ProductoBo productoToBo(Producto producto) {
		ProductoBo productoBo = mapper.map(producto, ProductoBo.class);
		return productoBo;
	}
}
