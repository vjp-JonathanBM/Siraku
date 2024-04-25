package com.viewnext.siraku.backend.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class ComercialDto {
	private Long codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
}
