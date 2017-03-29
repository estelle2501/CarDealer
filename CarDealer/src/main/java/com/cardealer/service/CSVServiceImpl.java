package com.cardealer.service;

import java.util.List;

import com.cardealer.csv.adapter.CSVAdapter;
import com.cardealer.model.Car;

public class CSVServiceImpl implements CSVService {


	public void CSVImportCars() {
		
		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		
	}

}
