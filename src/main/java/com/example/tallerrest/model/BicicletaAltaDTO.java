/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO usado en la Request para el alta en el sistema de una Bicicleta
 */
@Data
public class BicicletaAltaDTO {

	/**
	 * Constructor
	 * @param color
	 * @param numSerie
	 */
	public BicicletaAltaDTO(String color, @NotNull @NotBlank @Size(min = 5, max = 5) String numSerie) {
		super();
		this.color = color;
		this.numSerie = numSerie;
	}

	private String color;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 5)
	private String numSerie;
	
	/**
	 * Devuelve un objeto de tipo Bicicleta
	 * @return Bicicleta
	 */
	public Bicicleta toBicicleta() {
		return new Bicicleta(color, Integer.valueOf(numSerie).intValue());
	}
}
