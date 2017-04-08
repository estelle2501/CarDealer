package com.cardealer.model;

public class InvalidYearFormatException extends Exception{

	private static final long serialVersionUID = 7458978404825375489L;
	
	public InvalidYearFormatException(){
        super();
    }

    public InvalidYearFormatException(String message){
        super(message);
    }

}
