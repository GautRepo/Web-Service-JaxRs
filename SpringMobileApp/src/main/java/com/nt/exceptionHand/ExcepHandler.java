package com.nt.exceptionHand;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nt.model.ErrorMsg;
import com.nt.model.UserServiceExcep;

@ControllerAdvice
public class ExcepHandler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyExce(Exception ex, WebRequest web){
		
		String errDis= ex.getLocalizedMessage();
		if(errDis==null) {
			errDis=ex.toString();
		}
		ErrorMsg err= new ErrorMsg(new Date(),errDis);
		
		return new ResponseEntity<>(err, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/*@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullEx(NullPointerException ex, WebRequest web){
		
		String errDis= ex.getLocalizedMessage();
		if(errDis==null) {
			errDis=ex.toString();
		}
		ErrorMsg err= new ErrorMsg(new Date(),errDis);
		
		return new ResponseEntity<>(err, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value= {UserServiceExcep.class})
	public ResponseEntity<Object> handleUserServiceEx(UserServiceExcep ex, WebRequest web){
		
		String errDis= ex.getLocalizedMessage();
		if(errDis==null) {
			errDis=ex.toString();
		}
		ErrorMsg err= new ErrorMsg(new Date(),errDis);
		
		return new ResponseEntity<>(err, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}*/
	
	@ExceptionHandler(value= {UserServiceExcep.class,NullPointerException.class})
	public ResponseEntity<Object> handleUserServiceEx(Exception ex, WebRequest web){
		
		String errDis= ex.getLocalizedMessage();
		if(errDis==null) {
			errDis=ex.toString();
		}
		ErrorMsg err= new ErrorMsg(new Date(),errDis);
		
		return new ResponseEntity<>(err, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
