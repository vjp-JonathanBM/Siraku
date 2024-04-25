package com.viewnext.siraku.backend.presentation.controllers;

import java.io.Serializable;

public class MensajeError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	private int codigo;
	
	public MensajeError(String mensaje, int codigo) {
		this.mensaje = mensaje;
		
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "MensajeError [mensaje=" + mensaje + ", codigo=" + codigo + "]";
	}
	
}
