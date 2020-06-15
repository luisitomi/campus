package com.dev.op.core.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.op.core.dto.getListTablesModel;
import com.dev.op.core.mapper.getListTablesMapper;
import com.dev.op.core.repository.jdbc.getListTablesJdbcRepository;
import com.dev.op.core.util.Constantes;

@Repository("getListTablesJdbcRepository")
public class getListTablesCustomJdbcRepository implements getListTablesJdbcRepository{

private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<getListTablesModel> getListTables() {
		List<getListTablesModel> getListTables = new ArrayList<getListTablesModel>();

		try {
			
			simpleJdbcCall.withProcedureName(Constantes.GETLISTTABLES);
			simpleJdbcCall.returningResultSet("getListTables", new getListTablesMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			getListTables = (List<getListTablesModel>) result.get("getListTables");
			return getListTables;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
