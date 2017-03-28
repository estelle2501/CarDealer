package com.cardealer.csv.adapter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCSVAdapter {

	@Test
	public void testReadCSV() {
		CSVAdapter ca = new CSVAdapter();
		ca.readCSV();
	}

}
