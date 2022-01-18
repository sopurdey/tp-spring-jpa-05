package fr.diginamic.tpspringjpa05.controllerrest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.tpspringjpa05.exception.BanqueNotFoundException;
import fr.diginamic.tpspringjpa05.model.Banque;
import fr.diginamic.tpspringjpa05.model.Client;
import fr.diginamic.tpspringjpa05.repository.iCrudBanque;

@RestController
@CrossOrigin
@RequestMapping("api/banque")
public class ControllerBanque {
	@Autowired
	iCrudBanque cb;

	@GetMapping("all")
	public Iterable<Banque> getBanques() {
		
		return cb.findAll();
	}

	@GetMapping("{id}")
	public Optional<Banque> getBanque(@PathVariable("id") Integer pid) throws BanqueNotFoundException {
		if (cb.findById(pid).isEmpty()) {
			String s = "Banque non trouvé - id : " + pid;
			throw new BanqueNotFoundException(s);
		}
		return cb.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBanque(@PathVariable("id") Integer pid) throws BanqueNotFoundException {
		if (cb.findById(pid).isEmpty()) {
			String s = "Banque non trouvé - id : " + pid;
			throw new BanqueNotFoundException(s);
		}
		cb.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Banque supprimé !");
	}

	@PutMapping("{id}")
	public Banque updateBanque(@PathVariable("id") Integer pid, @RequestBody Banque banque)
			throws BanqueNotFoundException {
		if (pid != banque.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le banque JSON " + banque;
			throw new BanqueNotFoundException(s);
		}
		if (cb.findById(pid).isEmpty()) {
			String s = "Banque non trouvé, id: " + pid;
			throw new BanqueNotFoundException(s);
		}
		return cb.save(banque);
	}

	@PostMapping
	public Banque addBanque(@RequestBody Banque banque) {
		return cb.save(banque);
	}

	@GetMapping("{id}/clients")
	public Iterable<Client> getClients(@PathVariable("id") Integer pid) {
		return cb.findByClient(pid);
	}
}
