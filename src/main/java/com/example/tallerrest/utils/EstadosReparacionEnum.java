/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.utils;

/**
 * Enumerador con los distintos estados del proceso de una reparación
 */
public enum EstadosReparacionEnum {

	PENDIENTE("0"),
	ENCURSO("2"),
	FINALIZADA("1");

	private String codigo;
	
	private EstadosReparacionEnum(String codigo) {
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
