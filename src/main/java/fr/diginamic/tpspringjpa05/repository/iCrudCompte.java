package fr.diginamic.tpspringjpa05.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.tpspringjpa05.model.AssuranceVie;
import fr.diginamic.tpspringjpa05.model.Client;
import fr.diginamic.tpspringjpa05.model.Compte;
import fr.diginamic.tpspringjpa05.model.CompteCourant;
import fr.diginamic.tpspringjpa05.model.LivretA;
import fr.diginamic.tpspringjpa05.model.Operation;

public interface iCrudCompte extends CrudRepository<Compte, Integer> {
	
	@Query("select o from Operation o where o.compte.id = :id")
	public Iterable<Operation> findByOperation(int id);
	
	@Query("select c from Client c where :cpt MEMBER OF c.comptes")
	public Iterable<Client> findByCompte(Compte cpt);
	
	// Récupérer tous les comptes, peu importe le type
	@Query("select c from Compte c")
	public Iterable<Compte> getAllComptes();
	
	@Query("select a from AssuranceVie a")
	public Iterable<AssuranceVie> getAllAssuranceVies();

	@Query("select c from CompteCourant c")
	public Iterable<CompteCourant> getAllComptesCourant();
	
	@Query("select l from LivretA l")
	public Iterable<LivretA> getAllLivretAs();
}
