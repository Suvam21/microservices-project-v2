package com.mpv2.userMicroservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mpv2.userMicroservice.payload.apiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<apiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
	       
	  String message = ex.getMessage();
	  apiResponse response = apiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	  return new ResponseEntity<apiResponse>(response, HttpStatus.NOT_FOUND);

	 }
}



