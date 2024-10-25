/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.servicios;

import java.util.List;

import com.example.tallerrest.model.Bicicleta;
import com.example.tallerrest.model.BicicletaDTO;
import com.example.tallerrest.model.RespuestaServicio;
import com.example.tallerrest.utils.EstadosReparacionEnum;

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
	 * @param bicicleta
	 * @return RespuestaServicio
	 */
	public RespuestaServicio recogerBiciCliente(Bicicleta bicicleta);
	
	/**
	 * Método que actualiza la propiedad estadoReparacion de un objeto Bicicleta
	 * @param bicicleta
	 * @return RespuestaServicio
	 * @see EstadosReparacionEnum
	 */
	public RespuestaServicio actualizarEstadoReparacion(Bicicleta bicicleta);
	
	/**
	 * Método para recuperar todas las bicicletas del sistema
	 * @return List<BicicletaDTO>
	 */
	public List<BicicletaDTO> obtenerBicisTaller();
}
