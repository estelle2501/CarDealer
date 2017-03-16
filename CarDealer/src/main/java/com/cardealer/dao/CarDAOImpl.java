package com.cardealer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarDAOImpl {

	private final String url = "jdbc:postgresql://localhost:5432/cardealer";
	private final String user = "postgres";
	private final String password = "marchewka3";

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgresSQL successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
