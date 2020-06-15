package com.dev.op.core.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.op.core.dto.ResponseBaseOperation;
import com.dev.op.core.dto.dataMultitableCreateUpdate;
import com.dev.op.core.dto.getListAllTablesModel;
import com.dev.op.core.dto.getListTablesModel;
import com.dev.op.core.facade.MultitableFacade;
import com.dev.op.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/multitable")
public class MultitableRestController {
	
	@Autowired
	@Qualifier("multitableFacade")
	private MultitableFacade multitableFacade;
	
	@GetMapping("/getListTables")
	public ResponseEntity<List<getListTablesModel>> getListTables() {
		
		try{
			List<getListTablesModel> getListTables = multitableFacade.getListTables();
			if(!GenericUtil.isCollectionEmpty(getListTables)) {
				return new ResponseEntity<List<getListTablesModel>>(getListTables, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<getListTablesModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<getListTablesModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getListAllTables")
	public ResponseEntity<List<getListAllTablesModel>> getListAllTables() {
		
		try{
			List<getListAllTablesModel> getListAllTables = multitableFacade.getListAllTables();
			if(!GenericUtil.isCollectionEmpty(getListAllTables)) {
				return new ResponseEntity<List<getListAllTablesModel>>(getListAllTables, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<getListAllTablesModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<getListAllTablesModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/postMultitableCreate")
	public ResponseEntity<ResponseBaseOperation> postMultitableCreate(
			@Valid @RequestBody dataMultitableCreateUpdate request) {
		
		try {
			request.set_option(0);
			ResponseBaseOperation response = multitableFacade.updateCliente(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/putMultitableUpdate")
	public ResponseEntity<ResponseBaseOperation> putMultitableUpdate(
			@Valid @RequestBody dataMultitableCreateUpdate request) {
		
		try {
			request.set_option(1);
			ResponseBaseOperation response = multitableFacade.updateCliente(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteMultitable/{id}")
	public ResponseEntity<ResponseBaseOperation> deleteMultitableDeelete(
			@PathVariable(value="id") Integer id) {
		
		try {
			ResponseBaseOperation response = multitableFacade.spMultitableDelete(id);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
