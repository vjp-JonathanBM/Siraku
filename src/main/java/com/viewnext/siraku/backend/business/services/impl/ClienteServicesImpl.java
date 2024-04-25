package com.viewnext.siraku.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.model.Cliente;
import com.viewnext.siraku.backend.business.services.ClienteServices;
import com.viewnext.siraku.backend.repository.ClienteRepository;
import com.viewnext.siraku.util.Converter.Bo.BoToEntity;
import com.viewnext.siraku.util.Converter.Bo.EntityToBo;



@Service
public class ClienteServicesImpl implements ClienteServices{
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EntityToBo entityToBo;

	@Autowired
	BoToEntity boToEntity;
	@Override
	public ClienteBo create(ClienteBo clienteBo) {
		return entityToBo.clienteToBo(clienteRepository.save(boToEntity.clienteBoTocliente(clienteBo)));

	}

	@Override
	public ClienteBo read(String id) {
			Optional<Cliente> clienteOpt = clienteRepository.findById(id);
			if (clienteOpt.isPresent()) {
				Cliente cliente = clienteOpt.get();
				ClienteBo clienteBo = entityToBo.clienteToBo(cliente);
				return clienteBo;
			} else {
				return null;
			}
	}

	@Override
	public List<ClienteBo> getAll() {
		List<Cliente> clienteList = clienteRepository.findAll();
		List<ClienteBo> clienteBoList = new ArrayList<>();
		clienteList.forEach((cliente) -> clienteBoList.add(entityToBo.clienteToBo(cliente)));
		return clienteBoList;
	}


	@Override
	public void delete(String id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente updateCliente(ClienteBo clienteBo) {
		Cliente cliente = clienteRepository.save(boToEntity.clienteBoTocliente(clienteBo));
		return cliente;
	}

	
	
	
	
}
