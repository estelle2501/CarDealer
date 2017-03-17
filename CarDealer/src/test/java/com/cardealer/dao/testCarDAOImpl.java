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

		carDAOImpl.addCar(car);

	}

	@Ignore
	@Test
	public void testAddCarWithWrongAttributes() {
		Car car = new Car();
		car.setManufactureYear(20099);
		car.setModel("Alfa Romeo 159");
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		carDAOImpl.addCar(car);
	}

}
