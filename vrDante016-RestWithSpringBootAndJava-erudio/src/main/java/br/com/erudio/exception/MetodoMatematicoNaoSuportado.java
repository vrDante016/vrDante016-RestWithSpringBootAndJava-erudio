package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MetodoMatematicoNaoSuportado extends RuntimeException{

	public MetodoMatematicoNaoSuportado(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
