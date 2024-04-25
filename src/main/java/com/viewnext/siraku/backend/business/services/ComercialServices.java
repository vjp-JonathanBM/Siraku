package com.viewnext.siraku.backend.business.services;

import java.util.List;

import com.viewnext.siraku.backend.business.bo.ComercialBo;
import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.presentation.dto.ComercialDtoAux;

public interface ComercialServices {
	/**
	 * Crea un nuevo comercial
	 * 
	 * @param comercialBo
	 * @return
	 */
	ComercialBo create(ComercialBo comercialBo);

	/**
	 * Busca un comercial por su codigo
	 * 
	 * @param codigo
	 * @return
	 */
	ComercialBo read(long codigo);

	/**
	 * Obtiene la lista de todos los comerciales
	 * 
	 * @return
	 */

	List<ComercialBo> getAll();

	/**
	 * Retorna el numero total de comerciales
	 * 
	 * @return
	 */

	long getNumeroTotalComerciales();

	/**
	 * Actualiza un comercial existente
	 * 
	 * @param comercialBo
	 * @return
	 */

	ComercialBo updateComercial(ComercialBo comercialBo);

	/**
	 * Elimina un comercial por id
	 * 
	 * @param codigo
	 */

	public void delete(long codigo);
	
	public List<ComercialDtoAux> getComercialesDtoAux();

}
