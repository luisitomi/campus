package com.dev.op.core.service;

import java.util.List;

import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.dto.getListAllTablesModel;
import com.dev.op.core.dto.getListTablesModel;

public interface MultitableService {
	List<getListTablesModel> getListTables();
	List<getListAllTablesModel> getListAllTables();
	String spMultitableCreateUpdate(dataMultitableCreateUpdate request);
	String spMultitableDelete(Integer request);
}
