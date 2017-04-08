package com.cardealer.model;

public class InvalidLenghtException extends Exception{
	
	/**
	 * Thrown when field is too long
	 */

	private static final long serialVersionUID = 5157976052549865703L;

	public InvalidLenghtException(){
        super();
    }

    public InvalidLenghtException(String message){
        super(message);
    }

}
