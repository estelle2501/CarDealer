package com.cardealer.csv.adapter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cardealer.model.Car;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter ca = new CSVAdapter();
		ca.readCSV();
	}
	
	@Test
	public void testreadCarsFromCSV() {
		CSVAdapter ca = new CSVAdapter();
		List<Car> carsList = ca.readCarsFromCSV();
		for (Car c : carsList){
			System.out.println(c.toString());
		}
		
	}

}
