/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.tallerrest.utils.EstadosReparacionEnum;

import lombok.Data;

/**
 * Clase que representa la collection bicicleta
 */
@Document(collection="bicicleta")
@Data
public class Bicicleta {
	
	/**
	 * Constructor por defecto
	 */
	public Bicicleta() {
		super();
	}
	
	/**
	 * Constructor con parámetros
	 * @param color
	 * @param numSerie
	 */
	public Bicicleta(String color, int numSerie) {
		this.color = color;
		this.numSerie = numSerie;
		this.estadoReparacion = EstadosReparacionEnum.PENDIENTE.getCodigo();
	}
	
	/**
	 * Constructor con parámetros
	 * @param numSerie
	 * @param estadoReparacion
	 */
	public Bicicleta(int numSerie, String estadoReparacion) {
		this.numSerie = numSerie;
		this.estadoReparacion = estadoReparacion;
	}
	
	/**
	 * Constructor con parámetros
	 * @param color
	 * @param numSerie
	 */
	public Bicicleta(int numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * id autogenerado por mongoDB
	 */
	@Id
	public String id;
	
	private String color;
	
	@Indexed(unique = true)
	private int numSerie;
	
	private String estadoReparacion;
}
