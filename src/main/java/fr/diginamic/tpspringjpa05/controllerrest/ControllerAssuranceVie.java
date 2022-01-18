package fr.diginamic.tpspringjpa05.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.tpspringjpa05.exception.CompteNotFoundException;
import fr.diginamic.tpspringjpa05.model.AssuranceVie;
import fr.diginamic.tpspringjpa05.model.Compte;
import fr.diginamic.tpspringjpa05.model.CompteCourant;

@RestController
@CrossOrigin
@RequestMapping("api/assurancevie")
public class ControllerAssuranceVie extends ControllerCpt<AssuranceVie> {

	@Override
	public Iterable<AssuranceVie> getComptes() {

		return cc.getAllAssuranceVies();
	}

	@Override
	public AssuranceVie getCompte(@PathVariable("id") int pid) throws CompteNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte Assurance Vie non trouvé - id : " + pid;
			throw new CompteNotFoundException(s);
		}
		return (AssuranceVie) cc.findById(pid).get();
	}

	@Override
	public ResponseEntity<String> deleteCompte(Integer pid) throws CompteNotFoundException {
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte Assurance Vie non trouvé - id : " + pid;
			throw new CompteNotFoundException(s);
		}
		cc.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Compte supprimé !");
	}

	@Override
	public AssuranceVie updateCompte(Integer pid, Compte compte) throws CompteNotFoundException {
		if (pid != compte.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le compte JSON " + compte;
			throw new CompteNotFoundException(s);
		}
		if (cc.findById(pid).isEmpty()) {
			String s = "Compte Assurance Vie non trouvé, id: " + pid;
			throw new CompteNotFoundException(s);
		}
		return (AssuranceVie) cc.save(compte);
	}

	@Override
	public AssuranceVie addCompte(@RequestBody Compte compte) {

		return (AssuranceVie) cc.save(compte);
	}

	@Override
	public String getType() {

		return "Assurance Vie";
	}

}
