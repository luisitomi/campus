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

import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.util.Constantes;

@Repository("MultitableCreateUpdateJdbcRepository")
public class MultitableCreateUpdateCustomJdbcRepository implements MultitableCreateUpdateJdbcRepository{

private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spMultitableCreateUpdate(dataMultitableCreateUpdate request) {
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SPMULTITABLECREATEUPDATE);
			simpleJdbcCall.declareParameters(new SqlParameter("_tableId", Types.INTEGER),
											 new SqlParameter("_description", Types.VARCHAR),
											 new SqlParameter("_option", Types.INTEGER),
											 new SqlOutParameter("mensaje", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("_tableId", request.get_tableId());
			inParams.put("_description", request.get_description());
			inParams.put("_option", request.get_option());
			
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
