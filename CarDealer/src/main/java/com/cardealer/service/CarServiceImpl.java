package com.cardealer.service;

import java.util.List;

import com.cardealer.dao.CarDAO;
import com.cardealer.model.Car;

public class CarServiceImpl implements CarService {
	
	private CarDAO carDAO;

	public void setCarDAO(CarDAO carDAO){
		this.carDAO = carDAO;
	}

	public int addCar(Car c) {
		return this.carDAO.addCar(c);
	}

	public void updateCar(Car c) {
		this.carDAO.updateCar(c);
	}

	public Car getCarById(int id) {
		return this.carDAO.getCarById(id);
	}

	public void deleteCar(int id) {
		this.carDAO.deleteCar(id);
	}

	public List<Car> listCars() {
		return this.carDAO.listCars();
	}

	public List<Car> selectCarsByModel(String carModel) {
		return this.carDAO.selectCarsByModel(carModel);
	}

	public List<Car> selectCarsByYear(int year) {
		return this.carDAO.selectCarsByYear(year);
		}

	public void addCars(List<Car> carsList) {
		this.carDAO.addCars(carsList);
	}

}
