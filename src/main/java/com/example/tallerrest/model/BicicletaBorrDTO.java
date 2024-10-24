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
 * DTO usado en la Request para entregar y así eliminar una bici del sistema
 */
@Data
public class BicicletaBorrDTO {

	/**
	 * 
	 */
	public BicicletaBorrDTO() {
		super();
	}

	/**
	 * Constructor
	 * @param numSerie
	 * @param estadoReparacion
	 */
	public BicicletaBorrDTO(@NotNull @NotBlank @Size(min = 5, max = 5) String numSerie) {
		super();
		this.numSerie = numSerie;
	}

	@NotNull
	@NotBlank
	@Size(min = 5, max = 5)
	private String numSerie;
	
	/**
	 * Devuelve un objeto de tipo Bicicleta
	 * @return Bicicleta
	 */
	public Bicicleta toBicicleta() {
		return new Bicicleta(Integer.valueOf(numSerie).intValue());
	}
}
