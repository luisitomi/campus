package com.dev.op.core.repository.jdbc;

import java.util.List;

import com.dev.op.core.dto.getListAllTablesModel;

public interface getListAllTablesJdbcRepository {
	List<getListAllTablesModel> getListAllTables();
}
