package com.cardealer.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCarDAOImpl {

	// Testing simple jdbc postgres connection
	@Test
	public void testConnect() {
		CarDAOImpl carDAOImpl = new CarDAOImpl();
		carDAOImpl.connect();
	}

}
