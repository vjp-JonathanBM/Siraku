package com.viewnext.siraku.backend.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.viewnext.siraku.backend.business.util.Familia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	private String nombre;
	private double precio;
	
	private Date fechaAlta;
	
	@Column(name ="familia", columnDefinition = "ENUM")
	@Enumerated(EnumType.STRING)
	private Familia familia;
	private boolean descatalogado;
	
	@ManyToMany
	@JoinTable(name = "CLIENTE_PRODUCTOS", joinColumns = @JoinColumn(name = "PRODUCTO_CODIGO"))
	private List<Cliente> cliente;
	
	
}
