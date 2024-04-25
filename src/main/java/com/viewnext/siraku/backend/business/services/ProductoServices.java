package com.viewnext.siraku.backend.business.services;

import java.util.List;

import com.viewnext.siraku.backend.business.bo.ProductoBo;
import com.viewnext.siraku.backend.business.model.Producto;

public interface ProductoServices {
	/**
	 * Crea un nuevo producto
	 * 
	 * @param comercialBo
	 * @return
	 */
	Producto create(ProductoBo comercialBo);

	/**
	 * Busca un producto por su codigo
	 * 
	 * @param codigo
	 * @return
	 */
	ProductoBo read(long codigo);

	/**
	 * Se obtiene la lista de todos los productos
	 * 
	 * @return
	 */
	List<ProductoBo> getAll();

	/**
	 * Se actualizan un producto existente
	 * 
	 * @param productoBo
	 * @return
	 */

	Producto updateProducto(ProductoBo productoBo);
	
	/**
	 * Se elimina un producto existente por su id
	 * @param codigo
	 */

	public void delete(long codigo);

}
