package com.cardealer.model;

public class InvalidLenghtException extends Exception{

	private static final long serialVersionUID = 1L; 
	
	public InvalidLenghtException(){
        super();
    }

    public InvalidLenghtException(String message){
        super(message);
    }

}
