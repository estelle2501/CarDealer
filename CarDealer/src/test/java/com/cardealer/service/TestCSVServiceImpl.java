package com.cardealer.service;

import org.junit.Test;

public class TestCSVServiceImpl {

	CSVServiceImpl csvService = new CSVServiceImpl();

	@Test
	public void testCSVImportCars() {
		csvService.CSVImportCars();
	}

}
