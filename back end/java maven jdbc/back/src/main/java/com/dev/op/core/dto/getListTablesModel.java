package com.dev.op.core.dto;

import java.io.Serializable;

public class getListTablesModel implements Serializable{
	
	/**
	 * PROCEDURE getListTables
	 */
	private static final long serialVersionUID = 7440851506308938680L;
	
	private Integer itemId;
	
	private String description;

	public getListTablesModel() {
		
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
