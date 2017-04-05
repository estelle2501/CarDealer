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

	private static final String FILE_PATH = "C:/Users/Magda/git/CarDealerRepository/cars.csv";
	private static final String LINE_SEPARATOR = "\\s*,\\s*";
	private static String line = "";

	public static void readCSV() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			while ((line = br.readLine()) != null) {
				String[] cars = line.split(LINE_SEPARATOR);
				System.out.println(cars[0]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<Car> readCarsFromCSV() {

		List<Car> carsList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

			while ((line = br.readLine()) != null) {

				List<String> csvColumnsList = Arrays.asList(line.split(LINE_SEPARATOR));
				Car car = new Car();
				car.setMake(csvColumnsList.get(0));
				car.setModel(csvColumnsList.get(1));
				car.setYear(Integer.parseInt(csvColumnsList.get(2)));
				car.setFuel(csvColumnsList.get(3));
				car.setEngine(Float.parseFloat(csvColumnsList.get(4)));
				car.setGearbox(csvColumnsList.get(5));
				car.setColor(csvColumnsList.get(6));
				car.setKilometer(Integer.parseInt(csvColumnsList.get(7)));
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
