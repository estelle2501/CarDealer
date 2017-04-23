package com.cardealer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cardealer.model.Car;
import com.cardealer.model.InvalidEngineFormatException;
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

public class CarResultSetExtractor implements ResultSetExtractor<Car> {

	@Override
	public Car extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Car car = new Car();

		try {
			car.setKilometer(rs.getInt("kilometer"));
			car.setId(rs.getInt("id"));
			car.setMake(rs.getString("make"));
			car.setModel(rs.getString("model"));
			car.setYear(rs.getInt("year"));
			car.setFuel(rs.getString("fuel"));
			car.setEngine(rs.getFloat("engine"));
			car.setGearbox(rs.getString("gearbox"));
			car.setColor(rs.getString("color"));
		} catch (InvalidKilometerRangeException e) {
			e.printStackTrace();
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		} catch (InvalidEngineFormatException e) {
			e.printStackTrace();
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		}
		return car;
	}

}
