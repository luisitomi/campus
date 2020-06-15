package com.dev.op.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.op.core.dto.ResponseBaseOperation;
import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.dto.getListAllTablesModel;
import com.dev.op.core.dto.getListTablesModel;
import com.dev.op.core.facade.MultitableFacade;
import com.dev.op.core.service.MultitableService;
import com.dev.op.core.util.Constantes;
import com.dev.op.core.util.GenericUtil;
import com.dev.op.core.util.StringUtil;;

@Component("multitableFacade")
public class MultitableFacadeImpl implements MultitableFacade{
	@Autowired
	@Qualifier("multitableService")
	private MultitableService multitableService;

	@Override
	public List<getListTablesModel> getListTables() {
		List<getListTablesModel> getListTables = new ArrayList<getListTablesModel>();
		
		try {
			
			getListTables = multitableService.getListTables();
			if(GenericUtil.isEmpty(getListTables)) {
				return null;
			}
			else {
				return getListTables;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<getListAllTablesModel> getListAllTables() {
		List<getListAllTablesModel> getListAllTables = new ArrayList<getListAllTablesModel>();
		
		try {
			
			getListAllTables = multitableService.getListAllTables();
			if(GenericUtil.isEmpty(getListAllTables)) {
				return null;
			}
			else {
				return getListAllTables;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation updateCliente(dataMultitableCreateUpdate request) {
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = multitableService.spMultitableCreateUpdate(request);
				if(StringUtil.eq(result, Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spMultitableDelete(Integer request) {
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = multitableService.spMultitableDelete(request);
				if(StringUtil.eq(result, Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.SUCCESS_STATUS, result, request);
				}
				else if(StringUtil.eq(result, Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, request);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
