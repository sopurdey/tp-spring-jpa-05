package fr.diginamic.tpspringjpa05.controllerrest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.tpspringjpa05.exception.VirementNotFoundException;
import fr.diginamic.tpspringjpa05.model.Virement;
import fr.diginamic.tpspringjpa05.repository.iCrudVirement;

@RestController
@RequestMapping("api/virement")
public class ControllerVirement {
	@Autowired
	iCrudVirement cv;

	@GetMapping("all")
	public Iterable<Virement> getVirements() {
		
		return cv.findAll();
	}

	@GetMapping("{id}")
	public Optional<Virement> getVirement(@PathVariable("id") Integer pid) throws VirementNotFoundException {
		if (cv.findById(pid).isEmpty()) {
			String s = "Virement non trouvé - id : " + pid;
			throw new VirementNotFoundException(s);
		}
		return cv.findById(pid);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVirement(@PathVariable("id") Integer pid) throws VirementNotFoundException {
		if (cv.findById(pid).isEmpty()) {
			String s = "Virement non trouvé - id : " + pid;
			throw new VirementNotFoundException(s);
		}
		cv.deleteById(pid);
		return ResponseEntity.status(HttpStatus.OK).body("Virement supprimé !");
	}
	
	@PutMapping("{id}")
	public Virement updateVirement(@PathVariable("id") Integer pid, @RequestBody Virement virement) throws VirementNotFoundException {
		if (pid != virement.getId()) {
			String s = "Error pathvariable entre l'id : " + pid + " et le virement JSON " + virement;
			throw new VirementNotFoundException(s);
		}
		if (cv.findById(pid).isEmpty()) {
			String s = "Virement non trouvé, id: " + pid;
			throw new VirementNotFoundException(s);
		}
		return cv.save(virement);
	}
	
	@PostMapping
	public Virement addVirement(@RequestBody Virement virement) {
		return cv.save(virement);
	}
}
