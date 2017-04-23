package com.cardealer.csv.adapter;

import java.util.List;

import org.junit.Test;

import com.cardealer.model.Car;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter.readCSV();
	}

	@Test
	public void testReadCarsFromCSV() {

		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		for (Car c : carsList) {
			System.out.println(c.toString());
		}

	}

}
