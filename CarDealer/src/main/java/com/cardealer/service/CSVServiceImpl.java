package com.cardealer.service;

import java.util.List;

import com.cardealer.csv.adapter.CSVAdapter;
import com.cardealer.dao.CarDAOImpl;
import com.cardealer.model.Car;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormat;

public class CSVServiceImpl implements CSVService {

	CarDAOImpl carDAOImpl = new CarDAOImpl();

	public void CSVImportCars() throws InvalidLenghtException, InvalidYearFormat {
		
		List<Car> carsList = CSVAdapter.readCarsFromCSV();
		carDAOImpl.addCars(carsList);		
	}

}
