package fr.diginamic.tpspringjpa05.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.tpspringjpa05.model.Banque;
import fr.diginamic.tpspringjpa05.model.Client;

public interface iCrudBanque extends CrudRepository<Banque, Integer> {

		 @Query("select c from Client c where c.banque.id = :id")
		 public Iterable<Client> findByClient(int id);
}
