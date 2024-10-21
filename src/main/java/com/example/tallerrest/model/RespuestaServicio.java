/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.model;

import lombok.Data;

/**
 * Clase usada como Response del servicio web
 */
@Data
public class RespuestaServicio {

	/**
	 * Constructor por defecto
	 */
	public RespuestaServicio() {
		super();
	}

	public RespuestaServicio(String mensaje) {
		this.codigo = mensaje.substring(0, 2);
		this.mensaje = mensaje.substring(4, mensaje.length() - 1);
	}
	
	public RespuestaServicio(StringBuilder mensaje) {
		this.codigo = "KO";
		this.mensaje = mensaje.toString();
	}

	private String codigo;
	
	private String mensaje;
}
