package com.viewnext.siraku.backend.business.bo;

import java.util.Date;
import java.util.List;

import com.viewnext.siraku.backend.business.model.Cliente;
import com.viewnext.siraku.backend.business.util.Familia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoBo {
	private Long codigo;
	private String nombre;
	private double precio;
	private Date fechaAlta;
	private Familia familia;
	private boolean descatalogado;
	private List<Cliente> cliente;
}
