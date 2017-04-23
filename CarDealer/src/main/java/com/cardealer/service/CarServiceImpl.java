package com.cardealer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cardealer.spring.dao.CarDAOSpring;
import com.cardealer.model.Car;

public class CarServiceImpl implements CarService {

	@Autowired
	CarDAOSpring carDAOSpring;

	public void setCarDAOSpring(CarDAOSpring carDAOSpring){
		this.carDAOSpring = carDAOSpring;
	}

	public void addCar(Car c) {
		this.carDAOSpring.addCar(c);
	}

	public void updateCar(Car c) {
		this.carDAOSpring.updateCar(c);
	}

	public Car getCarById(int id) {
		return this.carDAOSpring.getCarById(id);
	}

	public void deleteCar(int id) {
		this.carDAOSpring.deleteCar(id);
	}

	public List<Car> listCars() {
		return this.carDAOSpring.listCars();
	}

	public List<Car> selectCarsByModel(String carModel) {
		return this.carDAOSpring.selectCarsByModel(carModel);
	}

	public List<Car> selectCarsByYear(int year) {
		return this.carDAOSpring.selectCarsByYear(year);
		}

	public void addCars(List<Car> carsList) {
		this.carDAOSpring.addCars(carsList);
	}

}
