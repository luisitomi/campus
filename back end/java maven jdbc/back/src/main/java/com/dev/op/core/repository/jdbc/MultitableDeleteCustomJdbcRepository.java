package com.dev.op.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.op.core.util.Constantes;

@Repository("MultitableDeleteJdbcRepository")
public class MultitableDeleteCustomJdbcRepository implements MultitableDeleteJdbcRepository{

private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spMultitableDelete(Integer request) {
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SPMULTITABLEDELETE);
			simpleJdbcCall.declareParameters(new SqlParameter("id", Types.INTEGER),
											 new SqlOutParameter("mensaje", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("id", request);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			String result = (String) out.get("mensaje");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
