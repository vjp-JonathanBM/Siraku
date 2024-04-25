package com.viewnext.siraku.backend.business.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String identificadorFiscal;
	private String nombreComercial;
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "CODIGO_DIRECCION")
	private Direccion direccion;
	
	private String apellido1;
	private String apellido2;
	
	
	@Embedded
	private DatosContacto datosContacto;
	
	@ManyToOne
	@JoinColumn(name = "codigoComercial")
	private Comercial comercial;
	
	@ManyToMany
	@JoinTable(name = "CLIENTE_PRODUCTOS", joinColumns = @JoinColumn(name = "CLIENTE_IDENTIFICADOR_FISCAL"))
	private List<Producto> producto;

	
}
