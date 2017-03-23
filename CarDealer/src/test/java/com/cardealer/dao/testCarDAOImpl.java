package com.cardealer.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

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

	@Test
	public void testAddCar() {
		Car car = new Car();
		car.setManufactureYear(2009);
		car.setModel("Alfa Romeo 159");

		int id = carDAOImpl.addCar(car);
		assertNotEquals(0, id);

	}

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
		Car car = null;
		car = carDAOImpl.getCarById(id);
		assertEquals(id, car.getId());

	}

	@Test
	public void testUpdateCar() {
		Car car = new Car();
		car.setManufactureYear(2018);
		car.setModel("Alfa Romeo Julia");

		/* I don't like the fact I have to setId to the car 
		 * shouldn't addCar do this?
		 * And it is still lacking error handling
		 * what if there is a mistake when adding to DB?
		 * there should be exeptions and notification
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
	public void testDeleteCar(){
		Car car = new Car();
		car.setManufactureYear(2013);
		car.setModel("Alfa Romeo Mito");

		car.setId(carDAOImpl.addCar(car));
		
		System.out.println(car);
		
		/*
		 * What is better
		 * deleteCar (id) or deleteCar (Car) ?
		 */
		
		carDAOImpl.deleteCar(car.getId());
		
		System.out.println(carDAOImpl.getCarById(car.getId()));
		
	}

}
