package com.dev.op.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.dto.getListAllTablesModel;
import com.dev.op.core.dto.getListTablesModel;
import com.dev.op.core.repository.jdbc.getListTablesJdbcRepository;
import com.dev.op.core.repository.jdbc.MultitableCreateUpdateJdbcRepository;
import com.dev.op.core.repository.jdbc.MultitableDeleteJdbcRepository;
import com.dev.op.core.repository.jdbc.getListAllTablesJdbcRepository;
import com.dev.op.core.service.MultitableService;
import com.dev.op.core.util.GenericUtil;
import com.dev.op.core.util.StringUtil;

@Service("multitableService")
@Transactional("hibernateTransactionManager")
public class MultitableServiceImpl implements MultitableService{

	@Autowired
	@Qualifier("getListTablesJdbcRepository")
	private getListTablesJdbcRepository getListTablesJdbcRepository;
	
	@Autowired
	@Qualifier("getListAllTablesJdbcRepository")
	private getListAllTablesJdbcRepository getListAllTablesJdbcRepository;
	
	@Autowired
	@Qualifier("MultitableCreateUpdateJdbcRepository")
	private MultitableCreateUpdateJdbcRepository MultitableCreateUpdateJdbcRepository;
	
	@Autowired
	@Qualifier("MultitableDeleteJdbcRepository")
	private MultitableDeleteJdbcRepository MultitableDeleteJdbcRepository;
	
	@Override
	public List<getListTablesModel> getListTables() {
		List<getListTablesModel> getListTables = new ArrayList<getListTablesModel>();
		
		try {
			
			getListTables = getListTablesJdbcRepository.getListTables();
			if(GenericUtil.isCollectionEmpty(getListTables)) {
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
			
			getListAllTables = getListAllTablesJdbcRepository.getListAllTables();
			if(GenericUtil.isCollectionEmpty(getListAllTables)) {
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
	public String spMultitableCreateUpdate(dataMultitableCreateUpdate request) {
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = MultitableCreateUpdateJdbcRepository.spMultitableCreateUpdate(request);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spMultitableDelete(Integer request) {
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = MultitableDeleteJdbcRepository.spMultitableDelete(request);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
