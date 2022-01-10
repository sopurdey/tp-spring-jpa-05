package fr.diginamic.tpspringjpa05.repository;

import org.springframework.data.repository.CrudRepository;

import fr.diginamic.tpspringjpa05.model.Operation;

public interface iCrudOperation extends CrudRepository<Operation, Integer> {

}
