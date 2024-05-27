package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timeDate;
	private String message;
	private String detaisl;
	
	
	public ExceptionResponse(Date timeDate, String message, String detaisl) {
		this.timeDate = timeDate;
		this.message = message;
		this.detaisl = detaisl;
	}


	public Date getTimeDate() {
		return timeDate;
	}


	public String getMessage() {
		return message;
	}


	public String getDetaisl() {
		return detaisl;
	}
	
	

}
