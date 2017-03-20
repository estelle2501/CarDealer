package com.cardealer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				PreparedStatement pstmt = conn.prepareStatement(SQL,
						Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, car.getModel());
			pstmt.setInt(2, car.getManufactureYear());

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				// get the ID
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
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
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCar(int id) {
		// TODO Auto-generated method stub

	}
}
