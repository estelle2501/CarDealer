package com.cardealer.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.cardealer.mapper.CarMapper;
import com.cardealer.model.Car;

public class CarDAOSpringImpl implements CarDAOSpring {

	@Autowired
	DataSource dataSource;

	private String SQLinsert = "INSERT INTO cars"
			+ " (make, model, year, fuel, engine, gearbox, color, kilometer)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public void addCar(Car car) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				SQLinsert,
				new Object[] { car.getMake(), car.getModel(), car.getYear(),
						car.getFuel(), car.getEngine(), car.getGearbox(),
						car.getColor(), car.getKilometer() });
	}

	public void updateCar(Car car) {
		String SQLupdate = "UPDATE cars "
				+ "SET make =?, model = ?, year = ? , fuel = ?, engine = ?, "
				+ "gearbox = ?, color = ?, kilometer = ? " + "WHERE id = ?";

	}

	public Car getCarById(int id) {
		String SQLgetCar = "SELECT id, make, model, year, fuel, "
				+ " engine, gearbox, color, kilometer " + "FROM cars "
				+ "WHERE id = ?";
		Car car = new Car();

		return car;
	}

	public List<Car> selectCarsByModel(String carModel) {
		String SQLSelectModel = "SELECT id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer  "
				+ "FROM cars WHERE model = ?";
		List<Car> foundCarsList = new ArrayList<>();

		return foundCarsList;
	}

	public List<Car> selectCarsByYear(int year) {
		String SQLSelectModel = "SELECT  id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer "
				+ "FROM cars WHERE year = ?";
		List<Car> foundCarsList = new ArrayList<>();

		return foundCarsList;
	}

	public void addCars(List<Car> carsList) {

	}

	public List<Car> listCars() {
		List<Car> foundCarsList = new ArrayList<>();

		String SQLSelect = "SELECT  * FROM cars ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		foundCarsList = jdbcTemplate.query(SQLSelect, new CarMapper());

		return foundCarsList;
	}

	public void deleteCar(int id) {	
		String SQLDelete = "DELETE FROM cars WHERE id=?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(SQLDelete, id);	

	}
}
