package com.viewnext.siraku.backend.business.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	private String direccion;
	private String poblacion;
	private String codigoPostal;
	private String provincia;
	private String pais;
	
	}
