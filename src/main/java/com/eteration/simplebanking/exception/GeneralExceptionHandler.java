/*package com.eteration.simplebanking.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;
@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler  {

	   // @NotNull
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                   HttpHeaders headers,
	                                                                   HttpStatus status,
	                                                                   WebRequest request) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);

	        });
	        return new ResponseEntity<>(errors, BAD_REQUEST);
	    }

	    @ExceptionHandler(AccountNotFoundException.class)
	    public ResponseEntity<?> accountNotFoundExceptionHandler(AccountNotFoundException exception) {
	        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
	   

}
*/