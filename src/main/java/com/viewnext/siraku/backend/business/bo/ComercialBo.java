package com.viewnext.siraku.backend.business.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class ComercialBo {
	private Long codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
}
