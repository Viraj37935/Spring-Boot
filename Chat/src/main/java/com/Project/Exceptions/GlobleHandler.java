package com.Project.Exceptions;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleHandler {

	@ExceptionHandler(FileAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleFileAlreadyExistsException(FileAlreadyExistsException ex) {
		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatuscode(409);
		er.setTime(LocalDateTime.now());
		er.setTrace(ex.getStackTrace()[0].toString());

		return new ResponseEntity<ErrorResponse>(er, HttpStatus.CONFLICT);
	}
}
