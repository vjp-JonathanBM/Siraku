package com.viewnext.siraku.backend.business.services;

import java.util.List;

import com.viewnext.siraku.backend.business.bo.ClienteBo;
import com.viewnext.siraku.backend.business.model.Cliente;

public interface ClienteServices {
	/**
	 * Crea un nuevo cliente
	 * 
	 * @param comercialBo
	 * @return
	 */
	ClienteBo create(ClienteBo comercialBo);

	/**
	 * Busca un cliente por id
	 * 
	 * @param id
	 * @return
	 */
	ClienteBo read(String id);

	/**
	 * Muestra todos los clientes
	 * 
	 * @return
	 */

	List<ClienteBo> getAll();

	/**
	 * Actualiza un cliente por su id
	 * 
	 * @param comercialBo
	 * @return
	 */

	Cliente updateCliente(ClienteBo comercialBo);

	/**
	 * Elimina un cliente
	 * 
	 * @param id
	 */

	public void delete(String id);

}
