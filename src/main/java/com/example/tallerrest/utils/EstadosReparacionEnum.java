/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.utils;

/**
 * Enumerador con los distintos estados del proceso de una reparación
 */
public enum EstadosReparacion {

	PENDIENTE("0"),
	ENPROCESO("2"),
	FINALIZADA("1");

	private String codigo;
	
	private EstadosReparacion(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * getter
	 * @return String
	 */
	public String getCodigo() {
		return codigo;
	}
}
