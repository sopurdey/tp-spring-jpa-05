package fr.diginamic.tpspringjpa05.controllerrest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice pour attraper les erreurs d'exceptions Java
 * @author A Purdey
 *
 */
@RestControllerAdvice
public class ErrorController {

	public ErrorController() {

	}

	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String errorGeneralException(Exception e) {
		String message = "Il y a une erreur : " + e.getMessage();
		
		return message;
		}

}
