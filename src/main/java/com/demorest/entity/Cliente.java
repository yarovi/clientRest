package com.demorest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	int codigo;
	String nroDocumento;
	String nombres;
	Double prestamo;
	int cantidad;
	
}
