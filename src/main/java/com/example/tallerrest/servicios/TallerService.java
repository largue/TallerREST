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
	 * M�todo para la entrega de un bici al taller
	 * @param bicicleta
	 * @return RespuestaServicio
	 */
	public RespuestaServicio entregarBiciAlTaller(Bicicleta bicicleta);
	
	/**
	 * M�todo para la recogida de una bici cuando el trabajo est� finalizado
	 * @param numSerie
	 * @return RespuestaServicio
	 * @see EstadosReparacion
	 */
	public RespuestaServicio recogerBiciCliente(int numSerie);
	
	/**
	 * M�todo que actualiza la propiedad estadoReparacion de un objeto Bicicleta
	 * @param bicicleta
	 * @return RespuestaServicio
	 */
	public RespuestaServicio actualizarEstadoReparacion(Bicicleta bicicleta);
}
