package com.exception;

public class RecordNotFoundException extends Exception {
	private String message;

	public RecordNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RecordNotFoundException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.getMessage();
	}
	
	

}
