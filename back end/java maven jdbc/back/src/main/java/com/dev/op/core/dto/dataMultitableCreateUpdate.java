package com.dev.op.core.dto;

import java.io.Serializable;

public class dataMultitableCreateUpdate implements Serializable{
	
	/**
	 * PROCEDURE MultitableCreateUpdate
	 */
	private static final long serialVersionUID = 7440851506308938680L;
	
	private Integer _tableId;
	
	private String _description;
	
	private Integer _option;

	public dataMultitableCreateUpdate() {
		
	}

	public Integer get_tableId() {
		return _tableId;
	}

	public void set_tableId(Integer _tableId) {
		this._tableId = _tableId;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public Integer get_option() {
		return _option;
	}

	public void set_option(Integer _option) {
		this._option = _option;
	}
	
}
