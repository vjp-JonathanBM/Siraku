package com.viewnext.siraku.backend.business.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Comercial implements Serializable{
	public Comercial(Long codigo, String nombre, String apellido1, String apellido2) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
	}
	public Comercial() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
		
}
