package com.viewnext.siraku.backend.presentation.main;

import com.viewnext.siraku.backend.business.model.Producto;
import com.viewnext.siraku.backend.business.services.ProductoServices;
import com.viewnext.siraku.backend.business.services.impl.ProductoServicesImpl;
import com.viewnext.siraku.backend.presentation.controllers.ProductoController;

public class Prueba {

	public static void main(String[] args) {
		ProductoController p = new ProductoController();
		ProductoServices ps = new ProductoServicesImpl();
        
	}

}
