/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO usado en la Request para modificar el estado de una reparación
 */
@Data
public class BicicletaModDTO {

	/**
	 * Constructor
	 * @param numSerie
	 * @param estadoReparacion
	 */
	public BicicletaModDTO(@NotNull @NotBlank @Size(min = 5, max = 5) String numSerie,
			@NotNull @NotBlank @Pattern(regexp = "[0 - 1 - 2]") String estadoReparacion) {
		super();
		this.numSerie = numSerie;
		this.estadoReparacion = estadoReparacion;
	}

	@NotNull
	@NotBlank
	@Size(min = 5, max = 5)
	private String numSerie;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "[0 - 1 - 2]")
	private String estadoReparacion;
	
	/**
	 * Devuelve un objeto de tipo Bicicleta
	 * @return Bicicleta
	 */
	public Bicicleta toBicicleta() {
		return new Bicicleta(Integer.valueOf(numSerie).intValue(), estadoReparacion);
	}
}
