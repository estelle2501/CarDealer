package com.cardealer.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.cardealer.model.Car;
import com.cardealer.model.InvalidEngineFormatException;
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

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
		try {
			car.setMake("Alfa Romeo");
			car.setModel("159");
			car.setFuel("diesel");
			car.setGearbox("manual");
			car.setColor("red");
			car.setYear(2009);
			car.setKilometer(76000);
			car.setEngine(1.9f);
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		} catch (InvalidKilometerRangeException e) {
			e.printStackTrace();
		} catch (InvalidEngineFormatException e) {
			e.printStackTrace();
		}

		carDAOImpl.addCar(car);

	}

	@Ignore
	@Test(expected = InvalidYearFormatException.class)
	public void testAddCarWithInvalidYearFormat20098()
			throws InvalidYearFormatException {
		Car car = new Car();
		car.setYear(20098);
		try {
			car.setMake("Alfa Romeo");
			car.setModel("159");
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		}
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test(expected = InvalidYearFormatException.class)
	public void testAddCarWithInvalidYearFormat123()
			throws InvalidYearFormatException {
		Car car = new Car();
		car.setYear(123);
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test(expected = InvalidLenghtException.class)
	public void testAddCarWithInvalidLengthException()
			throws InvalidLenghtException {
		Car car = new Car();
		car.setMake("Alfa Romeo Alfa Romeo Alfa Romeo");
		car.setModel("159");
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test(expected = InvalidKilometerRangeException.class)
	public void testAddCarWithInvalidKilometerRangeException1000000()
			throws InvalidKilometerRangeException, InvalidLenghtException {
		Car car = new Car();
		car.setMake("Alfa Romeo");
		car.setModel("159");
		car.setKilometer(1000000);
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test
	public void testAddCarWithInvalidKilometerRangeException999999()
			throws InvalidKilometerRangeException, InvalidLenghtException {
		Car car = new Car();
		car.setMake("Alfa Romeo");
		car.setModel("159");
		car.setKilometer(999999);
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test(expected = InvalidEngineFormatException.class)
	public void testAddCarWithInvalidEngineFormat100()
			throws InvalidKilometerRangeException, InvalidLenghtException,
			InvalidEngineFormatException {
		Car car = new Car();
		car.setMake("Alfa Romeo");
		car.setModel("159");
		car.setEngine(100);
	}

	@Ignore
	@Test
	public void testAddCarWithValidEngineFormat()
			throws InvalidKilometerRangeException, InvalidLenghtException,
			InvalidEngineFormatException {
		Car car = new Car();
		car.setMake("Alfa Romeo");
		car.setModel("159");
		car.setEngine(1.7f);
		carDAOImpl.addCar(car);
	}

	@Ignore
	@Test
	public void testGetCarByID() {
		int id = 110;
		Car car = carDAOImpl.getCarById(id);
		assertEquals(id, car.getId());

	}

	@Ignore
	@Test
	public void testUpdateCar() {
		Car car = new Car();
		try {
			car.setYear(2018);
		} catch (InvalidYearFormatException e1) {
			e1.printStackTrace();
		}
		try {
			car.setMake("Alfa Romeo");
			car.setModel("Giulia");
		} catch (InvalidLenghtException e) {
		}

		car.setId(carDAOImpl.addCar(car));

		System.out.println("Car: " + car);

		try {
			car.setYear(2017);
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		}
		carDAOImpl.updateCar(car);

		System.out
				.println("Updated car: " + carDAOImpl.getCarById(car.getId()));

	}

	@Ignore
	@Test
	public void testDeleteCar() {
		Car car = new Car();
		try {
			car.setYear(2013);
		} catch (InvalidYearFormatException e1) {
			e1.printStackTrace();
		}
		try {
			car.setMake("Alfa Romeo");
			car.setModel("Mito");
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		}

		carDAOImpl.addCar(car);

		car.setId(id);

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
