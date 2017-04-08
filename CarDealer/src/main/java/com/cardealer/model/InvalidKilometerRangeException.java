package com.cardealer.model;

public class InvalidKilometerRangeException extends Exception {

	private static final long serialVersionUID = -8214508621035668078L;

	public InvalidKilometerRangeException() {
		super();
	}

	public InvalidKilometerRangeException(String message) {
		super(message);
	}

}
