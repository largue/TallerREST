/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.model;

import lombok.Data;

/**
 * Clase para mostrar en pantalla un objeto de tipo Bicicleta
 */
@Data
public class BicicletaDTO {
	
	/**
	 * Constructor por defecto
	 */
	public BicicletaDTO() {
		super();
	}
	
	private String color;
	
	private int numSerie;
	
	private String estadoReparacion;
}
