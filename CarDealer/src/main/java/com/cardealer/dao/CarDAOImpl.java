package com.cardealer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.StampedLock;

import com.cardealer.model.Car;

public class CarDAOImpl implements CarDAO {

	private final String url = "jdbc:postgresql://localhost:5432/cardealer";
	private final String user = "postgres";
	private final String password = "marchewka3";

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public int addCar(Car car) {
		String SQL = "INSERT INTO cars (model, manufacture_year)"
				+ "VALUES (?,?)";

		int id = 0;

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQL,
						Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, car.getModel());
			statement.setInt(2, car.getManufactureYear());

			int affectedRows = statement.executeUpdate();

			if (affectedRows > 0) {
				// get the ID
				try (ResultSet rs = statement.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getInt(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return id;

	}

	public void updateCar(Car c) {
		// TODO Auto-generated method stub

	}

	public Car getCarById(int id) {
		String SQL = "SELECT id, model, manufacture_year "
				+ "FROM cars "
				+ "WHERE id = ?";
		Car car = new Car();

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQL)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				car.setId(rs.getInt("id"));
				car.setModel(rs.getString("model"));
				car.setManufactureYear(rs.getInt("manufacture_year"));				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return car;
	}

	public void deleteCar(int id) {
		// TODO Auto-generated method stub

	}
}
