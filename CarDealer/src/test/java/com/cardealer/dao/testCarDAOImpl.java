package com.cardealer.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.xa.XAResource;

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
	
	@Ignore
	@Test
	public void testAddCar() {
		Car car = new Car();
		car.setManufactureYear(2009);
		car.setModel("Alfa Romeo 159");

		int id = carDAOImpl.addCar(car);
		assertNotEquals(0, id);

	}

	@Ignore
	@Test
	public void testAddCarWithWrongAttributes() {
		Car car = new Car();
		car.setManufactureYear(20099);
		car.setModel("Alfa Romeo 159");

		int id = carDAOImpl.addCar(car);
		assertEquals(0, id);
	}

	@Test
	public void testGetCarByID() {
		int id = 12;
		Car car = carDAOImpl.getCarById(id);
		assertEquals(id, car.getId());

	}

	@Ignore
	@Test
	public void testUpdateCar() {
		Car car = new Car();
		car.setManufactureYear(2018);
		car.setModel("Alfa Romeo Giulia");

		/*
		 * I don't like the fact I have to setId to the car shouldn't addCar do
		 * this? And it is still lacking error handling what if there is a
		 * mistake when adding to DB? there should be exeptions and notification
		 * that car was not added
		 */

		car.setId(carDAOImpl.addCar(car));

		System.out.println("Car: " + car);

		car.setManufactureYear(2017);
		carDAOImpl.updateCar(car);

		System.out
				.println("Updated car: " + carDAOImpl.getCarById(car.getId()));

	}

	@Test
	public void testDeleteCar() {
		Car car = new Car();
		car.setManufactureYear(2013);
		car.setModel("Alfa Romeo Mito");

		int id = carDAOImpl.addCar(car);

		car.setId(id);

		/*
		 * What is better deleteCar (id) or deleteCar (Car) ?
		 */
		carDAOImpl.deleteCar(id);

	}

	@Test
	public void testSelectCarsByModel() {
		List<Car> foundCars159 = carDAOImpl.selectCarsByModel("Alfa Romeo 159");

		System.out.println("Number of found Alfa Romeo 159: "
				+ foundCars159.size());

		List<Car> foundCarsMito = carDAOImpl.selectCarsByModel("Alfa Romeo Mito");

		System.out.println("Number of found Alfa Romeo Mito: "
				+ foundCarsMito.size());
		
		List<Car> foundCarsGiulia = carDAOImpl.selectCarsByModel("Alfa Romeo Giulia");

		System.out.println("Number of found Alfa Romeo Giulia: "
				+ foundCarsGiulia.size());

	}
	
	@Test
	public void testSelectCarsByManufactureYear() {
		int manufactureYear2004 = 2004;
		List<Car> foundCars2004 = carDAOImpl.selectCarsByManufactureYear(manufactureYear2004);

		System.out.println("Number of found cars of manufacture year 2004: "
				+ foundCars2004.size());
	}

}
