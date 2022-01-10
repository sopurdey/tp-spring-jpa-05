package fr.diginamic.tpspringjpa05.controllerrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.diginamic.tpspringjpa05.exception.AssuranceVieNotFoundException;
import fr.diginamic.tpspringjpa05.exception.BanqueNotFoundException;
import fr.diginamic.tpspringjpa05.exception.ClientNotFoundException;
import fr.diginamic.tpspringjpa05.exception.CompteNotFoundException;
import fr.diginamic.tpspringjpa05.exception.LivretANotFoundException;
import fr.diginamic.tpspringjpa05.exception.OperationNotFoundException;
import fr.diginamic.tpspringjpa05.exception.VirementNotFoundException;

@RestControllerAdvice
public class ControllerGeneralError {
	
	@ExceptionHandler(value = { AssuranceVieNotFoundException.class })
	public ResponseEntity<String> onErrorAssuranceVie(AssuranceVieNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CompteError - AssuranceVie: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { BanqueNotFoundException.class })
	public ResponseEntity<String> onErrorBanque(BanqueNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BanqueError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { ClientNotFoundException.class })
	public ResponseEntity<String> onErrorClient(ClientNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClientError: " + ex.getMessage());
	}

	@ExceptionHandler(value = { CompteNotFoundException.class })
	public ResponseEntity<String> onErrorCompte(CompteNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CompteError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { LivretANotFoundException.class })
	public ResponseEntity<String> onErrorLivretA(LivretANotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CompteError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { OperationNotFoundException.class })
	public ResponseEntity<String> onErrorOperation(OperationNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OperationError: " + ex.getMessage());
	}
	
	@ExceptionHandler(value = { VirementNotFoundException.class })
	public ResponseEntity<String> onErrorVirement(VirementNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VirementError: " + ex.getMessage());
	}

	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<String> onError(Exception ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Other error: " + ex.getMessage());
	}

}
