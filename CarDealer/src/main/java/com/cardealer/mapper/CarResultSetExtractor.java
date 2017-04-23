package com.cardealer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cardealer.model.Car;

public class CarResultSetExtractor implements ResultSetExtractor<Car> {

	@Override
	public Car extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Car car = new Car();

		car.setKilometer(rs.getInt("kilometer"));
		car.setId(rs.getInt("id"));
		car.setMake(rs.getString("make"));
		car.setModel(rs.getString("model"));
		car.setYear(rs.getInt("year"));
		car.setFuel(rs.getString("fuel"));
		car.setEngine(rs.getFloat("engine"));
		car.setGearbox(rs.getString("gearbox"));
		car.setColor(rs.getString("color"));

		return car;
	}

}
