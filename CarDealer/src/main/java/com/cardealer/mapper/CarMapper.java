package com.cardealer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cardealer.model.Car;

public class CarMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CarResultSetExtractor extractor = new CarResultSetExtractor();
		return extractor.extractData(rs);
	}

}
