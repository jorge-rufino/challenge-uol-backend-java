package com.rufino.uolhost.exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
		ExceptionDto dto = new ExceptionDto("Há campos nulos ou em branco", "400");
		
		return ResponseEntity.badRequest().body(dto);
	}
}
