package com.cardealer.csv.adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVAdapter {

	private final String filePath = "C:/Users/Magda/git/CarDealerRepository/cars.csv";
	private final String separator = ",";
	String line = "";

	public void readCSV() {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			while ((line = br.readLine()) != null) {
				String[] cars = line.split(separator);
				System.out.println(cars[0]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
