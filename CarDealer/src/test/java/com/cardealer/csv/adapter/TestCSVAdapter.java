package com.cardealer.csv.adapter;

import java.util.List;
import org.junit.Test;

import com.cardealer.model.Car;
import com.cardealer.model.InvalidEngineFormatException;
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter.readCSV();
	}
	
	@Test
	public void testReadCarsFromCSV() throws InvalidLenghtException,
			InvalidYearFormatException, NumberFormatException,
			InvalidKilometerRangeException, InvalidEngineFormatException {
		
		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		for (Car c : carsList){
			System.out.println(c.toString());
		}
		
	}

}
