package com.rufino.uolhost.exception;

import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException exception) {
		ExceptionDto dto = new ExceptionDto("Não existem mais codinomes disponíveis.", "400");
		
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {
		
		Set<ConstraintViolation<?>> list = exception.getConstraintViolations();
		
		String message = "";		
		
		for(ConstraintViolation<?> obj : list) {
			String field = obj.getPropertyPath().toString();
			
			if(field.equals("email")) {
				message = "Campo email inválido.";
			}
			
			if(field.equals("name")) {
				message = "Campo nome inválido.";
			}
		}
		
		ExceptionDto dto = new ExceptionDto(message, "400");
		
		return ResponseEntity.badRequest().body(dto);
	}
}
