package com.cardealer.dao;

import com.cardealer.model.Car;

public interface CarDAO {

	public int addCar (Car c);
	public void updateCar (Car c);
	public Car getCarById (int id);
	public void deleteCar(int id);
	
}
