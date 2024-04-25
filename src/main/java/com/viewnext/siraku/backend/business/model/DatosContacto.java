package com.viewnext.siraku.backend.business.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DatosContacto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String telefono1;
	private String telefono2;
	private String email;
	
		
}
