package com.cardealer.csv.adapter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cardealer.model.Car;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter.readCSV();
	}
	
	@Test
	public void testreadCarsFromCSV() {
		
		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		for (Car c : carsList){
			System.out.println(c.toString());
		}
		
	}

}
