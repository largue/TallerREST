/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.servicios;

import com.example.tallerrest.model.Bicicleta;
import com.example.tallerrest.model.RespuestaServicio;
import com.example.tallerrest.utils.EstadosReparacion;

/**
 * Interfaz para el servicio del taller
 */
public interface TallerService {
	
	/**
	 * Método para la entrega de un bici al taller
	 * @param bicicleta
	 * @return RespuestaServicio
	 */
	public RespuestaServicio entregarBiciAlTaller(Bicicleta bicicleta);
	
	/**
	 * Método para la recogida de una bici cuando el trabajo está finalizado
	 * @param numSerie
	 * @return RespuestaServicio
	 * @see EstadosReparacion
	 */
	public RespuestaServicio recogerBiciCliente(int numSerie);
	
	/**
	 * Método que actualiza la propiedad estadoReparacion de un objeto Bicicleta
	 * @param bicicleta
	 * @return RespuestaServicio
	 */
	public RespuestaServicio actualizarEstadoReparacion(Bicicleta bicicleta);
}
