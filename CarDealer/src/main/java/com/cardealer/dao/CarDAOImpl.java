package com.cardealer.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import com.cardealer.model.Car;

public class CarDAOImpl implements CarDAO {

	private static final String CARS_MANUFACTURE_YEAR = "manufacture_year";
	private static final String CARS_MODEL = "model";
	private static final String CARS_ID = "id";
	private final String url = "jdbc:postgresql://localhost:5432/cardealer";
	private final String user = "postgres";
	private final String password = "marchewka3";

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public int addCar(Car car) {
		String SQLinsert = "INSERT INTO cars (model, manufacture_year)"
				+ "VALUES (?,?)";

		int id = 0;

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLinsert,
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

	public void updateCar(Car car) {
		String SQLupdate = "UPDATE cars SET model = ?, manufacture_year = ? WHERE id = ?";

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLupdate)) {
			statement.setString(1, car.getModel());
			statement.setInt(2, car.getManufactureYear());
			statement.setInt(3, car.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Car getCarById(int id) {
		String SQLgetCar = "SELECT id, model, manufacture_year " + "FROM cars "
				+ "WHERE id = ?";
		Car car = new Car();

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLgetCar)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				car.setId(rs.getInt(CARS_ID));
				car.setModel(rs.getString(CARS_MODEL));
				car.setManufactureYear(rs.getInt(CARS_MANUFACTURE_YEAR));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return car;
	}

	public void deleteCar(int id) {
		String SQLDelete = "DELETE FROM cars WHERE id = ?";

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLDelete)) {

			statement.setInt(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Car> selectCarsByModel(String carModel) {
		String SQLSelectModel = "SELECT id, manufacture_year, model FROM cars WHERE model = ?";
		List<Car> foundCarsList = new ArrayList<>();

		try (Connection conn = connect();
				PreparedStatement statement = conn
						.prepareStatement(SQLSelectModel)) {

			statement.setString(1, carModel);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(CARS_ID));
				car.setManufactureYear(rs.getInt(CARS_MANUFACTURE_YEAR));
				car.setModel(rs.getString(CARS_MODEL));

				foundCarsList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foundCarsList;
	}

	public List<Car> selectCarsByManufactureYear(int manufactureYear) {
		// TODO Auto-generated method stub
		return null;
	}
}
