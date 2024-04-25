package com.viewnext.siraku.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.bo.ProductoBo;
import com.viewnext.siraku.backend.business.model.Producto;
import com.viewnext.siraku.backend.business.model.Producto;
import com.viewnext.siraku.backend.business.services.ProductoServices;
import com.viewnext.siraku.backend.repository.ProductoRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;

@Service
public class ProductoServicesImpl implements ProductoServices {
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	EntityToBo entityToBo;

	@Autowired
	BoToEntity boToEntity;

	@Override
	public Producto create(ProductoBo productoBo) {
		Producto producto = productoRepository.save(boToEntity.productoBoToproducto(productoBo));
		return producto;
	}

	@Override
	public ProductoBo read(long codigo) {
		Optional<Producto> productoOpt = productoRepository.findById(codigo);
		if (productoOpt.isPresent()) {
			Producto producto = productoOpt.get();
			ProductoBo productoBo = entityToBo.productoToBo(producto);
			return productoBo;
		} else {
			return null;
		}
	}

	@Override
	public List<ProductoBo> getAll() {
		List<Producto> productoList = productoRepository.findAll();
		List<ProductoBo> productoBoList = new ArrayList<>();
		productoList.forEach((producto) -> productoBoList.add(entityToBo.productoToBo(producto)));
		return productoBoList;
	}

	@Override
	public Producto updateProducto(ProductoBo productoBo) {
		Producto producto = productoRepository.save(boToEntity.productoBoToproducto(productoBo));
		return producto;
	}

	@Override
	public void delete(long codigo) {
		productoRepository.deleteById(codigo);

	}

}
