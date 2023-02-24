package com.fvthree.springbootoktastarter.exception;

import java.io.Serializable;

public class RestAPIExceptionInfo implements Serializable {
	
	private static final long serialVersionUID = -5269627027142862492L;

	private String message;
	
	private String details;

	public RestAPIExceptionInfo() {
		message = null;
		details = null;
	}

	public RestAPIExceptionInfo(String message, String details) { 
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
