package org.SpringBoot.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?>Exception(ResourceNotFoundException ex,WebRequest request )
	{
	ErrorDetails details=new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
	return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globallyException(Exception ex,WebRequest request)
	{
		ErrorDetails details=new ErrorDetails( ex.getMessage(),HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
