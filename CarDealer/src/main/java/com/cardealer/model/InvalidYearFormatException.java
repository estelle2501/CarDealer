package com.cardealer.model;

public class InvalidYearFormatException extends Exception{
	
	/**
	 * Thrown when year format is other than [1000-9999]
	 */

	private static final long serialVersionUID = 7458978404825375489L;
	
	public InvalidYearFormatException(){
        super();
    }

    public InvalidYearFormatException(String message){
        super(message);
    }

}
