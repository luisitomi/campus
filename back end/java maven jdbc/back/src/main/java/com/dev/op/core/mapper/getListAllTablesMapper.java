package com.dev.op.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.op.core.dto.getListAllTablesModel;;

public class getListAllTablesMapper implements RowMapper<getListAllTablesModel> {
	
	@Override
	public getListAllTablesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		getListAllTablesModel getListAllTables = new getListAllTablesModel();
		getListAllTables.setItemId(rs.getInt("multitableId"));
		getListAllTables.setDescription(rs.getString("description"));
		getListAllTables.setSecond(rs.getString("second"));
		return getListAllTables;
	}
}
