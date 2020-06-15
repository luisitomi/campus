package com.dev.op.core.facade;

import java.util.List;

import com.dev.op.core.dto.ResponseBaseOperation;
import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.dto.getListAllTablesModel;
import com.dev.op.core.dto.getListTablesModel;

public interface MultitableFacade {
	List<getListTablesModel> getListTables();
	List<getListAllTablesModel> getListAllTables();
	ResponseBaseOperation updateCliente(dataMultitableCreateUpdate request);
	ResponseBaseOperation spMultitableDelete(Integer request);
}
