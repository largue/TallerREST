/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tallerrest.model.BicicletaAltaDTO;
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
	 * Método PUT /entregarBiciAlTaller
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
	 * Método GET /recogerBiciCliente
	 * @param numSerie
	 * @return RespuestaServicio
	 */
	@RequestMapping(path = "/recogerBiciCliente", method = RequestMethod.GET, produces={"application/json; charset=utf-8"})
	public RespuestaServicio recogerBiciCliente(@RequestParam("numSerie") int numSerie) {
		return tallerService.recogerBiciCliente(numSerie);
	}
	
	/**
	 * Método POST /actualizarEstadoReparacion
	 * @param request
	 * @param bindingResult
	 * @return RespuestaServicio
	 */
	//@PostMapping("/actualizarEstadoReparacion")
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
