package com.cardealer.csv.adapter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cardealer.model.Car;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormat;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter.readCSV();
	}
	
	@Test
	public void testReadCarsFromCSV() throws InvalidLenghtException, InvalidYearFormat {
		
		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		for (Car c : carsList){
			System.out.println(c.toString());
		}
		
	}

}
