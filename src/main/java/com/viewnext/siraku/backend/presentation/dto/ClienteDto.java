package com.viewnext.siraku.backend.presentation.dto;

import java.util.List;

import com.viewnext.siraku.backend.business.model.Comercial;
import com.viewnext.siraku.backend.business.model.DatosContacto;
import com.viewnext.siraku.backend.business.model.Direccion;
import com.viewnext.siraku.backend.business.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
	private String identificadorFiscal;
	private String nombreComercial;
	private String nombre;
	private Direccion direccion;
	private String apellido1;
	private String apellido2;
	private DatosContacto datosContacto;
	private Comercial comercial;
	private List<Producto> producto;
}
