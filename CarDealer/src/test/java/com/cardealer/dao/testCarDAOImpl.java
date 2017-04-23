package com.cardealer.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.cardealer.model.Car;

public class testCarDAOImpl {

	CarDAOImpl carDAOImpl = new CarDAOImpl();

	// Testing simple jdbc postgres connection
	@Test
	public void testConnect() {
		Exception ex = null;
		try {
			carDAOImpl.connect();
		} catch (SQLException e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testAddCar() {
		Car car = new Car();
		car.setMake("Alfa Romeo");
		car.setModel("159");
		car.setFuel("diesel");
		car.setGearbox("manual");
		car.setColor("red");
		car.setYear(2009);
		car.setKilometer(76000);
		car.setEngine(1.9f);
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test
	public void testGetCarByID() {
		int id = 110;
		Car car = carDAOImpl.getCarById(id);
		assertEquals(id, car.getId());

	}

	@Test
	public void testUpdateCar() {
		System.out.println("testUpdateCar");
		int id = 167;
		Car car = carDAOImpl.getCarById(id);
		System.out.println(" Car: " + car);

		car.setYear(2018);
		car.setMake("Alfa Romeo");
		car.setModel("Giulia");

		car.setYear(2017);

		carDAOImpl.updateCar(car);

		System.out
				.println("Updated car: " + carDAOImpl.getCarById(car.getId()));

	}

	@Ignore
	@Test
	public void testDeleteCar() {
		int id = 110;
		/*
		 * What is better deleteCar (id) or deleteCar (Car) ?
		 */
		carDAOImpl.deleteCar(id);

	}

	@Ignore
	@Test
	public void testSelectCarsByModel() {
		List<Car> foundCars159 = carDAOImpl.selectCarsByModel("159");

		System.out.println("Number of found Alfa Romeo 159: "
				+ foundCars159.size());

		List<Car> foundCarsMito = carDAOImpl.selectCarsByModel("Mito");

		System.out.println("Number of found Alfa Romeo Mito: "
				+ foundCarsMito.size());

		List<Car> foundCarsGiulia = carDAOImpl.selectCarsByModel("Giulia");

		System.out.println("Number of found Alfa Romeo Giulia: "
				+ foundCarsGiulia.size());

	}

	@Ignore
	@Test
	public void testSelectCarsByYear() {
		int Year = 2009;
		List<Car> foundCars2004 = carDAOImpl.selectCarsByYear(Year);

		System.out.println("Number of found cars of year:  " + Year
				+ foundCars2004.size());
	}

	@Ignore
	@Test
	public void testListCars() {
		List<Car> listCars = carDAOImpl.listCars();
		for (Car c : listCars) {
			System.out.println(c);
		}
	}

}
