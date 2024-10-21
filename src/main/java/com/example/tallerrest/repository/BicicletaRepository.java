/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.tallerrest.model.Bicicleta;

/**
 * Repositorio para la collection Bicicleta
 */
@RepositoryRestResource(collectionResourceRel = "bicicleta", path = "bicicleta")
public interface BicicletaRepository extends MongoRepository<Bicicleta, String> {

	/**
	 * Método que recupera un objeto Bicicleta a partir de su numSerie
	 * @param numSerie
	 * @return
	 */
	public Bicicleta findByNumSerie(@Param("numSerie") int numSerie);
}