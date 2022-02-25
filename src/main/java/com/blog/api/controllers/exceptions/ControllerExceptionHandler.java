package com.blog.api.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blog.api.services.exceptions.DatabaseException;
import com.blog.api.services.exceptions.UserAlreadyExistsException;
import com.blog.api.services.exceptions.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<StandardError> userAlreadyExists(UserAlreadyExistsException e){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandardError> userNotFoundException(UserNotFoundException e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataException(DatabaseException e){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

}
