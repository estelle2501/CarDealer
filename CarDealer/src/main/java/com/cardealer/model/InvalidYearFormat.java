package com.cardealer.model;

public class InvalidYearFormat extends Exception{

	private static final long serialVersionUID = 7458978404825375489L;
	
	public InvalidYearFormat(){
        super();
    }

    public InvalidYearFormat(String message){
        super(message);
    }

}
