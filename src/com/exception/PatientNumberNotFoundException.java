package com.exception;

public class PatientNumberNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public PatientNumberNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
