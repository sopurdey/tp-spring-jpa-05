package fr.diginamic.tpspringjpa05.repository;

import org.springframework.data.repository.CrudRepository;

import fr.diginamic.tpspringjpa05.model.Client;

public interface iCrudClient extends CrudRepository<Client, Integer> {

	
}
