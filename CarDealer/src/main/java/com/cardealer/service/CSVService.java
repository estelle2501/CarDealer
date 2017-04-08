package com.cardealer.service;

import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormat;

public interface CSVService {
	
	public void CSVImportCars() throws InvalidLenghtException, InvalidYearFormat;

}
