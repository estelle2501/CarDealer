package com.cardealer.model;

public class InvalidEngineFormatException extends Exception {

	/**
	 * Thrown when engine format is other n.n
	 * where n is numeric
	 */
	private static final long serialVersionUID = -2717723307984104101L;

	public InvalidEngineFormatException() {
		super();
	}

	public InvalidEngineFormatException(String message) {
		super(message);
	}
	
}
