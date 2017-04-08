package com.cardealer.service;

import org.junit.Test;

import com.cardealer.model.InvalidEngineFormatException;
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

public class TestCSVServiceImpl {

	CSVServiceImpl csvService = new CSVServiceImpl();

	@Test
	public void testCSVImportCars() throws NumberFormatException,
			InvalidLenghtException, InvalidYearFormatException,
			InvalidKilometerRangeException, InvalidEngineFormatException {
		csvService.CSVImportCars();
	}

}
