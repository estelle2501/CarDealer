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
import com.cardealer.model.InvalidKilometerRangeException;
import com.cardealer.model.InvalidLenghtException;
import com.cardealer.model.InvalidYearFormatException;

public class CarDAOImpl implements CarDAO {

	private static final String CARS_ID = "id";
	private static final String CARS_YEAR = "year";
	private static final String CARS_MAKE = "make";
	private static final String CARS_MODEL = "model";
	private static final String CARS_FUEL = "fuel";
	private static final String CARS_ENGINE = "engine";
	private static final String CARS_GEARBOX = "gearbox";
	private static final String CARS_COLOR = "color";
	private static final String CARS_KILOMETER = "kilometer";

	private final String url = "jdbc:postgresql://localhost:5432/cardealer";
	private final String user = "postgres";
	private final String password = "marchewka3";

	private String SQLinsert = "INSERT INTO cars "
			+ "(make, model, year, fuel, engine, gearbox, color, kilometer )"
			+ "VALUES (?,?,?,?,?,?,?,?) ";

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public int addCar(Car car) {

		int id = 0;

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLinsert,
						Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, car.getMake());
			statement.setString(2, car.getModel());
			statement.setInt(3, car.getYear());
			statement.setString(4, car.getFuel());
			statement.setFloat(5, car.getEngine());
			statement.setString(6, car.getGearbox());
			statement.setString(7, car.getColor());
			statement.setInt(8, car.getKilometer());

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
		String SQLupdate = "UPDATE cars "
				+ "SET make =?, model = ?, year = ? , fuel = ?, engine = ?, "
				+ "gearbox = ?, color = ?, kilometer = ? " + "WHERE id = ?";

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLupdate)) {
			statement.setString(1, car.getMake());
			statement.setString(2, car.getModel());
			statement.setInt(3, car.getYear());
			statement.setString(4, car.getFuel());
			statement.setFloat(5, car.getEngine());
			statement.setString(6, car.getGearbox());
			statement.setString(7, car.getColor());
			statement.setInt(8, car.getKilometer());

			statement.setInt(9, car.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Car getCarById(int id) {
		String SQLgetCar = "SELECT id, make, model, year, fuel, "
				+ " engine, gearbox, color, kilometer " + "FROM cars "
				+ "WHERE id = ?";
		Car car = new Car();

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLgetCar)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				car.setId(rs.getInt(CARS_ID));
				car.setMake(rs.getString(CARS_MAKE));
				car.setModel(rs.getString(CARS_MODEL));
				car.setYear(rs.getInt(CARS_YEAR));
				car.setFuel(rs.getString(CARS_FUEL));
				car.setEngine(rs.getFloat(CARS_ENGINE));
				car.setGearbox(rs.getString(CARS_GEARBOX));
				car.setColor(CARS_COLOR);
				car.setKilometer(rs.getInt(CARS_KILOMETER));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		} catch (InvalidKilometerRangeException e) {
			e.printStackTrace();
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
		String SQLSelectModel = "SELECT id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer  "
				+ "FROM cars WHERE model = ?";
		List<Car> foundCarsList = new ArrayList<>();

		try (Connection conn = connect();
				PreparedStatement statement = conn
						.prepareStatement(SQLSelectModel)) {

			statement.setString(1, carModel);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(CARS_ID));
				car.setMake(rs.getString(CARS_MAKE));
				car.setModel(rs.getString(CARS_MODEL));
				car.setYear(rs.getInt(CARS_YEAR));
				car.setFuel(rs.getString(CARS_FUEL));
				car.setEngine(rs.getFloat(CARS_ENGINE));
				car.setGearbox(rs.getString(CARS_GEARBOX));
				car.setKilometer(rs.getInt(CARS_KILOMETER));
				foundCarsList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidLenghtException e ) {
			e.printStackTrace();
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		} catch (InvalidKilometerRangeException e) {
			e.printStackTrace();
		}

		return foundCarsList;
	}

	public List<Car> selectCarsByYear(int year){
		String SQLSelectModel = "SELECT  id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer "
				+ "FROM cars WHERE year = ?";
		List<Car> foundCarsList = new ArrayList<>();

		try (Connection conn = connect();
				PreparedStatement statement = conn
						.prepareStatement(SQLSelectModel)) {

			statement.setInt(1, year);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(CARS_ID));
				car.setMake(rs.getString(CARS_MAKE));
				car.setModel(rs.getString(CARS_MODEL));
				car.setYear(rs.getInt(CARS_YEAR));
				car.setFuel(rs.getString(CARS_FUEL));
				car.setEngine(rs.getFloat(CARS_ENGINE));
				car.setGearbox(rs.getString(CARS_GEARBOX));
				car.setKilometer(rs.getInt(CARS_KILOMETER));

				foundCarsList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidLenghtException e) {
			e.printStackTrace();
		} catch (InvalidYearFormatException e) {
			e.printStackTrace();
		} catch (InvalidKilometerRangeException e) {
			e.printStackTrace();
		}

		return foundCarsList;
	}

	public void addCars(List<Car> carsList) {

		try (Connection conn = connect();
				PreparedStatement statement = conn.prepareStatement(SQLinsert,
						Statement.RETURN_GENERATED_KEYS)) {

			conn.setAutoCommit(false);

			for (Car car : carsList) {
				statement.setString(1, car.getMake());
				statement.setString(2, car.getModel());
				statement.setInt(3, car.getYear());
				statement.setString(4, car.getFuel());
				statement.setFloat(5, car.getEngine());
				statement.setString(6, car.getGearbox());
				statement.setString(7, car.getColor());
				statement.setInt(8, car.getKilometer());
				statement.addBatch();
			}

			statement.executeBatch();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
