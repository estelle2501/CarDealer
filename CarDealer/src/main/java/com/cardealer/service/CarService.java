package com.cardealer.service;

import java.util.List;
import com.cardealer.model.Car;

public interface CarService {
	
	public void addCar (Car c);
	public void updateCar (Car c);
	public Car getCarById (int id);
	public void deleteCar(int id);
	public List<Car> listCars();
	public List<Car> selectCarsByModel(String carModel);
	public List<Car> selectCarsByYear(int year);
	public void addCars(List<Car> carsList); 

}
