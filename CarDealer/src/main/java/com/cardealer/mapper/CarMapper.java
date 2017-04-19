package com.cardealer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cardealer.model.Car;

public class CarMapper implements RowMapper<Car> {

	public static final String BASE_SQL = //
	"Select c. id, c.make, c.model, c.year, c.fuel, "
			+ " c.engine, c.gearbox, c.color, c.kilometer "//
			+ " from cars c ";

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer carId = rs.getInt("id");
		String carMake = rs.getString("make");
		String carModel = rs.getString("model");
		Integer carYear = rs.getInt("year");
		String carFuel = rs.getString("fuel");
		Float carEngine = rs.getFloat("engine");
		String carGearbox = rs.getString("gearbox");
		String carColor = rs.getString("color");
		Integer carKilometer = rs.getInt("kilometer");

		return new Car(carId, carMake, carModel, carYear, carFuel, carEngine,
				carGearbox, carColor, carKilometer);
	}

}
