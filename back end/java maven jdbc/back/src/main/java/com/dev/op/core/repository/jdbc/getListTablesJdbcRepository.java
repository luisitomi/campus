package com.dev.op.core.repository.jdbc;

import java.util.List;

import com.dev.op.core.dto.getListTablesModel;

public interface getListTablesJdbcRepository {
	List<getListTablesModel> getListTables();
}
