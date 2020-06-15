package com.dev.op.core.dto;

import java.io.Serializable;

public class getListAllTablesModel implements Serializable{
	
	/**
	 * PROCEDURE getListAllTables
	 */
	private static final long serialVersionUID = 7440851506308938680L;
	
	private Integer itemId;
	
	private String second;
	
	private String description;

	public getListAllTablesModel() {
		
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

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
	
}
