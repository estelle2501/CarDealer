package com.cardealer.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cardealer.model.Car;

public class CarDAOSpringImpl implements CarDAOSpring {

	private String SQLinsert = "INSERT INTO cars"
			+ " (make, model, year, fuel, engine, gearbox, color, kilometer)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addCar(Car car) {

		jdbcTemplate = new JdbcTemplate(dataSource);

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

		// try (Connection conn = connect();
		// PreparedStatement statement = conn.prepareStatement(SQLupdate)) {
		// statement.setString(1, car.getMake());
		// statement.setString(2, car.getModel());
		// statement.setInt(3, car.getYear());
		// statement.setString(4, car.getFuel());
		// statement.setFloat(5, car.getEngine());
		// statement.setString(6, car.getGearbox());
		// statement.setString(7, car.getColor());
		// statement.setInt(8, car.getKilometer());
		//
		// statement.setInt(9, car.getId());
		//
		// statement.executeUpdate();
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

	}

	public Car getCarById(int id) {
		String SQLgetCar = "SELECT id, make, model, year, fuel, "
				+ " engine, gearbox, color, kilometer " + "FROM cars "
				+ "WHERE id = ?";
		Car car = new Car();

		// try (Connection conn = connect();
		// PreparedStatement statement = conn.prepareStatement(SQLgetCar)) {
		// statement.setInt(1, id);
		// ResultSet rs = statement.executeQuery();
		// while (rs.next()) {
		// car.setId(rs.getInt(CARS_ID));
		// car.setMake(rs.getString(CARS_MAKE));
		// car.setModel(rs.getString(CARS_MODEL));
		// car.setYear(rs.getInt(CARS_YEAR));
		// car.setFuel(rs.getString(CARS_FUEL));
		// car.setEngine(rs.getFloat(CARS_ENGINE));
		// car.setGearbox(rs.getString(CARS_GEARBOX));
		// car.setColor(rs.getString(CARS_COLOR));
		// car.setKilometer(rs.getInt(CARS_KILOMETER));
		// }
		//
		// } catch (SQLException ex) {
		// System.out.println(ex.getMessage());
		// } catch (InvalidLenghtException e) {
		// e.printStackTrace();
		// } catch (InvalidYearFormatException e) {
		// e.printStackTrace();
		// } catch (InvalidKilometerRangeException e) {
		// e.printStackTrace();
		// } catch (InvalidEngineFormatException e) {
		// e.printStackTrace();
		// }

		return car;
	}

	public void deleteCar(int id) {
		String SQLDelete = "DELETE FROM cars WHERE id = ?";

		// try (Connection conn = connect();
		// PreparedStatement statement = conn.prepareStatement(SQLDelete)) {
		//
		// statement.setInt(1, id);
		//
		// statement.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

	}

	public List<Car> selectCarsByModel(String carModel) {
		String SQLSelectModel = "SELECT id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer  "
				+ "FROM cars WHERE model = ?";
		List<Car> foundCarsList = new ArrayList<>();

		// try (Connection conn = connect();
		// PreparedStatement statement = conn
		// .prepareStatement(SQLSelectModel)) {
		//
		// statement.setString(1, carModel);
		//
		// ResultSet rs = statement.executeQuery();
		//
		// while (rs.next()) {
		// Car car = new Car();
		// car.setId(rs.getInt(CARS_ID));
		// car.setMake(rs.getString(CARS_MAKE));
		// car.setModel(rs.getString(CARS_MODEL));
		// car.setYear(rs.getInt(CARS_YEAR));
		// car.setFuel(rs.getString(CARS_FUEL));
		// car.setEngine(rs.getFloat(CARS_ENGINE));
		// car.setGearbox(rs.getString(CARS_GEARBOX));
		// car.setKilometer(rs.getInt(CARS_KILOMETER));
		// foundCarsList.add(car);
		// }
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } catch (InvalidLenghtException e) {
		// e.printStackTrace();
		// } catch (InvalidYearFormatException e) {
		// e.printStackTrace();
		// } catch (InvalidKilometerRangeException e) {
		// e.printStackTrace();
		// } catch (InvalidEngineFormatException e) {
		// e.printStackTrace();
		// }

		return foundCarsList;
	}

	public List<Car> selectCarsByYear(int year) {
		String SQLSelectModel = "SELECT  id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer "
				+ "FROM cars WHERE year = ?";
		List<Car> foundCarsList = new ArrayList<>();

		// try (Connection conn = connect();
		// PreparedStatement statement = conn
		// .prepareStatement(SQLSelectModel)) {
		//
		// statement.setInt(1, year);
		//
		// ResultSet rs = statement.executeQuery();
		//
		// while (rs.next()) {
		// Car car = new Car();
		// car.setId(rs.getInt(CARS_ID));
		// car.setMake(rs.getString(CARS_MAKE));
		// car.setModel(rs.getString(CARS_MODEL));
		// car.setYear(rs.getInt(CARS_YEAR));
		// car.setFuel(rs.getString(CARS_FUEL));
		// car.setEngine(rs.getFloat(CARS_ENGINE));
		// car.setGearbox(rs.getString(CARS_GEARBOX));
		// car.setKilometer(rs.getInt(CARS_KILOMETER));
		//
		// foundCarsList.add(car);
		// }
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } catch (InvalidLenghtException e) {
		// e.printStackTrace();
		// } catch (InvalidYearFormatException e) {
		// e.printStackTrace();
		// } catch (InvalidKilometerRangeException e) {
		// e.printStackTrace();
		// } catch (InvalidEngineFormatException e) {
		// e.printStackTrace();
		// }

		return foundCarsList;
	}

	public void addCars(List<Car> carsList) {

		// try (Connection conn = connect();
		// PreparedStatement statement = conn.prepareStatement(SQLinsert,
		// Statement.RETURN_GENERATED_KEYS)) {
		//
		// conn.setAutoCommit(false);
		//
		// for (Car car : carsList) {
		// statement.setString(1, car.getMake());
		// statement.setString(2, car.getModel());
		// statement.setInt(3, car.getYear());
		// statement.setString(4, car.getFuel());
		// statement.setFloat(5, car.getEngine());
		// statement.setString(6, car.getGearbox());
		// statement.setString(7, car.getColor());
		// statement.setInt(8, car.getKilometer());
		// statement.addBatch();
		// }
		//
		// statement.executeBatch();
		//
		// conn.commit();
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public List<Car> listCars() {
		String SQLSelectModel = "SELECT  id, make, model, year, fuel,"
				+ " engine, gearbox, color, kilometer " + "FROM cars ";
		List<Car> foundCarsList = new ArrayList<>();

		// try (Connection conn = connect();
		// PreparedStatement statement = conn
		// .prepareStatement(SQLSelectModel)) {
		//
		// ResultSet rs = statement.executeQuery();
		//
		// while (rs.next()) {
		// Car car = new Car();
		// car.setId(rs.getInt(CARS_ID));
		// car.setMake(rs.getString(CARS_MAKE));
		// car.setModel(rs.getString(CARS_MODEL));
		// car.setYear(rs.getInt(CARS_YEAR));
		// car.setFuel(rs.getString(CARS_FUEL));
		// car.setEngine(rs.getFloat(CARS_ENGINE));
		// car.setGearbox(rs.getString(CARS_GEARBOX));
		// car.setKilometer(rs.getInt(CARS_KILOMETER));
		//
		// foundCarsList.add(car);
		// }
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } catch (InvalidLenghtException e) {
		// e.printStackTrace();
		// } catch (InvalidYearFormatException e) {
		// e.printStackTrace();
		// } catch (InvalidKilometerRangeException e) {
		// e.printStackTrace();
		// } catch (InvalidEngineFormatException e) {
		// e.printStackTrace();
		// }

		return foundCarsList;
	}
}
