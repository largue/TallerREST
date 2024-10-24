/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.servicios;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.tallerrest.model.Bicicleta;
import com.example.tallerrest.model.RespuestaServicio;
import com.example.tallerrest.repository.BicicletaRepository;
import com.example.tallerrest.utils.EstadosReparacion;
import com.example.tallerrest.utils.StaticBundle;

/**
 * Implementación de la interfaz para el servicio del taller
 */
@Service
public class TallerServiceImpl implements TallerService {
	
	Logger logger = LoggerFactory.getLogger(TallerServiceImpl.class);
	
	@Autowired
	private BicicletaRepository bicicletaRepository;
	
	@Override
	public RespuestaServicio entregarBiciAlTaller(Bicicleta bicicleta) {
		String mensaje = "";
		Bicicleta bicicletaAux = null;
		boolean altaBici = true;
		
		try {
			List<Bicicleta> listadoBicisTaller = bicicletaRepository.findAll();
			
			if (!CollectionUtils.isEmpty(listadoBicisTaller) && listadoBicisTaller.size() >= 5) {
				altaBici = false;
			}
			
			if (altaBici) {
				bicicletaAux = bicicletaRepository.insert(bicicleta);
				
				if (bicicletaAux != null) {
					mensaje = StaticBundle.getInstance().getString("alta.bici.exito");
				}
			} else {
				mensaje = StaticBundle.getInstance().getString("alta.bici.taller.lleno");
			}
		} catch (DuplicateKeyException mwe) {
			mensaje = StaticBundle.getInstance().getString("alta.bici.error");
			logger.debug(mensaje, mwe);
		}
		
		return new RespuestaServicio(mensaje);
	}
	
	@Override
	public RespuestaServicio actualizarEstadoReparacion(Bicicleta bicicleta) {
		String mensaje = "";
		Bicicleta bicicletaAux = null;
		
		bicicletaAux = buscarBicicleta(bicicleta.getNumSerie());
		
		if (bicicletaAux == null) {
			mensaje = StaticBundle.getInstance().getString("bici.no.encontrada");
		} else {
			bicicletaAux.setEstadoReparacion(bicicleta.getEstadoReparacion());
			bicicletaRepository.save(bicicletaAux);
			
			mensaje = StaticBundle.getInstance().getString("actualizar.estado.reparacion");
		}
		
		return new RespuestaServicio(mensaje);
	}
	
	@Override
	public RespuestaServicio recogerBiciCliente(Bicicleta bicicleta) {
		String mensaje = "";
		Bicicleta biciAux = null;
		
		biciAux = buscarBicicleta(bicicleta.getNumSerie());
		
		if (biciAux == null) {
			mensaje = StaticBundle.getInstance().getString("bici.no.encontrada");
		} else {
			if (EstadosReparacion.FINALIZADA.getCodigo().equalsIgnoreCase(biciAux.getEstadoReparacion())) {
				bicicletaRepository.delete(biciAux);
				
				logger.debug(StaticBundle.getInstance().getString("info.eliminar.bici.db").replace("{0}",
						String.valueOf(bicicleta.getNumSerie())));
				mensaje = StaticBundle.getInstance().getString("entrega.bici.exito");
			} else {
				mensaje = StaticBundle.getInstance().getString("entrega.bici.error");
			}
		}
		
		return new RespuestaServicio(mensaje);
	}
	
	/**
	 * Método para buscar una Bicicleta en el sistema a partir de su numSerie
	 * @param numSerie
	 * @return Bicicleta
	 */
	private Bicicleta buscarBicicleta(int numSerie) {
		return bicicletaRepository.findByNumSerie(numSerie);
	}
}
