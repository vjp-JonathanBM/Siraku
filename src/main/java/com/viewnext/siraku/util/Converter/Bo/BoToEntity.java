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
public class BoToEntity {
	@Autowired
	ModelMapper mapper;

	public Comercial comercialBoTocomercial(ComercialBo comercialBo) {
		Comercial comercial = mapper.map(comercialBo, Comercial.class);
		return comercial;
	}

	public Cliente clienteBoTocliente(ClienteBo clienteBo) {
		Cliente cliente = mapper.map(clienteBo, Cliente.class);
		return cliente;
	}
	
	public Producto productoBoToproducto(ProductoBo productoBo) {
		Producto producto = mapper.map(productoBo,  Producto.class);
		return producto;
	}

}
