/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tallerrest.model.BicicletaAltaDTO;
import com.example.tallerrest.model.BicicletaBorrDTO;
import com.example.tallerrest.model.BicicletaDTO;
import com.example.tallerrest.model.BicicletaModDTO;
import com.example.tallerrest.model.RespuestaServicio;
import com.example.tallerrest.servicios.TallerService;

import jakarta.validation.Valid;

/**
 * Controller para la gestión del taller
 */
@RestController
@RequestMapping("/tallerREST")
public class TallerController {
	
	@Autowired
	private TallerService tallerService;
	
	/**
	 * Método POST /entregarBiciAlTaller
	 * @param request
	 * @param bindingResult
	 * @return RespuestaServicio
	 */
	@RequestMapping(path = "/entregarBiciAlTaller", method = RequestMethod.POST, produces={"application/json; charset=utf-8"})
	public RespuestaServicio entregarBiciAlTaller(@Valid @RequestBody BicicletaAltaDTO request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder sb = tratarErrores(bindingResult);
			
			return new RespuestaServicio(sb);
        } else {
        	return tallerService.entregarBiciAlTaller(request.toBicicleta());
        }
	}
	
	/**
	 * Método PUT /actualizarEstadoReparacion
	 * @param request
	 * @param bindingResult
	 * @return RespuestaServicio
	 */
	@RequestMapping(path = "/actualizarEstadoReparacion", method = RequestMethod.PUT, produces={"application/json; charset=utf-8"})
	public RespuestaServicio actualizarEstadoReparacion(@Valid @RequestBody BicicletaModDTO request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder sb = tratarErrores(bindingResult);
			
			return new RespuestaServicio(sb);
        } else {
			return tallerService.actualizarEstadoReparacion(request.toBicicleta());
        }
	}
	
	/**
	 * Método PUT /recogerBiciCliente
	 * @param numSerie
	 * @return RespuestaServicio
	 */
	@RequestMapping(path = "/recogerBiciCliente", method = RequestMethod.PUT, produces={"application/json; charset=utf-8"})
	public RespuestaServicio recogerBiciCliente(@Valid @RequestBody BicicletaBorrDTO request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder sb = tratarErrores(bindingResult);
			
			return new RespuestaServicio(sb);
        } else {
        	return tallerService.recogerBiciCliente(request.toBicicleta());
        }
	}
	
	/**
	 * Método GET /obtenerBicisTaller
	 * @param numSerie
	 * @return RespuestaServicio
	 */
	@RequestMapping(path = "/obtenerBicisTaller", method = RequestMethod.GET, produces={"application/json; charset=utf-8"})
	public @ResponseBody List<BicicletaDTO> obtenerBicisTaller() {
		return tallerService.obtenerBicisTaller();
	}
	
	/**
	 * Método que construye un objeto de tipo StringBuilder con los mensajes obtenidos de la validación de la Request
	 * @param bindingResult
	 * @return StringBuilder
	 */
	private StringBuilder tratarErrores(BindingResult bindingResult) {
		StringBuilder sb = new StringBuilder();
		bindingResult.getAllErrors().forEach((error) -> sb.append((((FieldError) error).getField() + " " 
						+ error.getDefaultMessage() + ". ")));
		
		return sb;
	}
}
