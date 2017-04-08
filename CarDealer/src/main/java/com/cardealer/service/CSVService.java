package com.cardealer.service;

import com.cardealer.model.InvalidEngineFormatException;
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

public interface CSVService {

	public void CSVImportCars() throws InvalidLenghtException,
			InvalidYearFormatException, NumberFormatException, InvalidKilometerRangeException, InvalidEngineFormatException;

}
