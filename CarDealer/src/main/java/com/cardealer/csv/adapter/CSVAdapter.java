package com.cardealer.csv.adapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cardealer.model.Car;

public class CSVAdapter {

	private final String FILE_PATH = "C:/Users/Magda/git/CarDealerRepository/cars.csv";
	private final String LINE_SEPARATOR = "\\s*,\\s*";
	String line = "";

	public void readCSV() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			while ((line = br.readLine()) != null) {
				String[] cars = line.split(LINE_SEPARATOR);
				System.out.println(cars[0]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Car> readCarsFromCSV() {

		List<Car> carsList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			while ((line = br.readLine()) != null) {

				List<String> csvColumnsList = Arrays.asList(line.split("\\s*,\\s*"));
				Car car = new Car();
				car.setModel(csvColumnsList.get(0));
				car.setManufactureYear(Integer.parseInt(csvColumnsList.get(1)));
				carsList.add(car);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return carsList;

	}
}