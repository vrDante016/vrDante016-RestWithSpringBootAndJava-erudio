package br.com.erudio.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exception.ExceptionResponse;
import br.com.erudio.exception.MetodoMatematicoNaoSuportado;

@ControllerAdvice
@RestController
public class ExceptionCustomizadaResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handAllExceptions(Exception e, WebRequest resquest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
				resquest.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(MetodoMatematicoNaoSuportado.class)
	public final ResponseEntity<ExceptionResponse> handBadRequestExceptions(Exception e, WebRequest resquest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
				resquest.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
	
}

