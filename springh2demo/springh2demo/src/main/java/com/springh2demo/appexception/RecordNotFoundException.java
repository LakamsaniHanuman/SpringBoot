package com.springh2demo.appexception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String message) {
	super(message);
	}

	 public RecordNotFoundException(String message, Throwable t) {
	super(message, t);
	}

	}