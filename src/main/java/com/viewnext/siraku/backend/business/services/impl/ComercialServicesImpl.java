package com.viewnext.siraku.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.business.services.ComercialServices;
import com.viewnext.siraku.backend.presentation.dto.ComercialDtoAux;
import com.viewnext.siraku.backend.repository.ComercialRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComercialServicesImpl implements ComercialServices { 
	@Autowired
	ComercialRepository comercialRepository;

	@Autowired
	EntityToBo entityToBo;

	@Autowired
	BoToEntity boToEntity;

	@Override
	public ComercialBo create(ComercialBo comercialBo) {
		return entityToBo.comercialToBo(comercialRepository.save(boToEntity.comercialBoTocomercial(comercialBo)));
		
	}

	@Override
	public ComercialBo updateComercial(ComercialBo comercialBo) { 
		return entityToBo.comercialToBo(comercialRepository.save(boToEntity.comercialBoTocomercial(comercialBo)));
	}

	@Override
	public ComercialBo read(long codigo) {
		return entityToBo.comercialToBo(comercialRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException("Id no encontrado")));

	}

	@Override
	public List<ComercialBo> getAll() {
		List<Comercial> comercialList = comercialRepository.findAll();
		List<ComercialBo> comercialBoList = new ArrayList<>();
		comercialList.forEach((comercial) -> comercialBoList.add(entityToBo.comercialToBo(comercial)));
		return comercialBoList;
	}

	@Override
	public long getNumeroTotalComerciales() {
		return comercialRepository.count();
	}

	@Override
	public void delete(long codigo) {
		comercialRepository.deleteById(codigo);

	}

	@Override
	public List<ComercialDtoAux> getComercialesDtoAux() {
		List<Object[]> listaObjetos = comercialRepository.getListaDeArrayDeObjetos();
		List<ComercialDtoAux> listaComercialesDtoAux = new ArrayList<>();
		
		for (Object[] fila : listaObjetos) {
			String nombre=(String)fila[0];
			String ap1 = (String)fila[1];
			String ap2 = (String)fila[2];
			
			ComercialDtoAux comercialDtoAux = new ComercialDtoAux();
			//comercialDtoAux.setCodigo(codigo);
			comercialDtoAux.setNombre(nombre);
			comercialDtoAux.setNombreCompleto(ap1+" "+ap2+", "+nombre);
			comercialDtoAux.setApellido1(ap1);
			comercialDtoAux.setApellido2(ap2);
			
			listaComercialesDtoAux.add(comercialDtoAux);
		}
		
		
		return listaComercialesDtoAux;
		
		
	}

}
