package com.dev.op.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.op.core.dto.getListTablesModel;;

public class getListTablesMapper implements RowMapper<getListTablesModel> {
	
	@Override
	public getListTablesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		getListTablesModel getListTables = new getListTablesModel();
		getListTables.setItemId(rs.getInt("itemId"));
		getListTables.setDescription(rs.getString("description"));
		return getListTables;
	}
}
