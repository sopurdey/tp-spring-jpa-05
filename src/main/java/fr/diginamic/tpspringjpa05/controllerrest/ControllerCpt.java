package fr.diginamic.tpspringjpa05.controllerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.tpspringjpa05.exception.CompteNotFoundException;
import fr.diginamic.tpspringjpa05.model.Compte;
import fr.diginamic.tpspringjpa05.repository.iCrudCompte;

@RestController
public abstract class ControllerCpt<T> extends Compte {

	@Autowired
	protected iCrudCompte cc;

	@GetMapping("all")
	public abstract Iterable<T> getComptes();

	@GetMapping("{id}")
	public abstract T getCompte(@PathVariable("id") int pid) throws CompteNotFoundException;

	@DeleteMapping("{id}")
	public abstract ResponseEntity<String> deleteCompte(@PathVariable("id") Integer pid) throws CompteNotFoundException;

	@PutMapping("{id}")
	public abstract T updateCompte(@PathVariable("id") Integer pid, @RequestBody Compte compte)
			throws CompteNotFoundException;

	@PostMapping
	public abstract T addCompte(@RequestBody Compte compte);

}
