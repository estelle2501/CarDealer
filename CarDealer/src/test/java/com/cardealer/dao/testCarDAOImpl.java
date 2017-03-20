package com.cardealer.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.cardealer.model.Car;

public class testCarDAOImpl {

	// Testing simple jdbc postgres connection
	@Test
	public void testConnect() {
		CarDAOImpl carDAOImpl = new CarDAOImpl();
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
		
		CarDAOImpl carDAOImpl = new CarDAOImpl();

		int id = carDAOImpl.addCar(car);
		assertNotEquals(0, id);

	}

	@Test
	public void testAddCarWithWrongAttributes() {
		Car car = new Car();
		car.setManufactureYear(20099);
		car.setModel("Alfa Romeo 159");
		
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		
		int id = carDAOImpl.addCar(car);
		assertEquals(0, id);
	}
	
	@Test
	public void testGetCarByID(){
		int id = 12;
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		Car car = null;
		car = carDAOImpl.getCarById(id);
		System.out.println(car);
		assertEquals(id, car.getId());
		
		
	}

}
