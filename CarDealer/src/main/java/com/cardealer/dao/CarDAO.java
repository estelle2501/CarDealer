package com.cardealer.dao;

import java.util.List;

import com.cardealer.model.Car;

public interface CarDAO {

	public void addCar (Car c);
	public void updateCar (Car c);
	public Car getCarById (int id);
	public void deleteCar(int id);
	public List<Car> selectCarsByModel(String carModel);
	public List<Car> selectCarsByYear(int year);
	public void addCars(List<Car> carsList);
	public List<Car> listCars(); 
}
