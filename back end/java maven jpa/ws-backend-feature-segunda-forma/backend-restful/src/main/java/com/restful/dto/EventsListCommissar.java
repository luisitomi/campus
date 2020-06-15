package com.restful.dto;

import java.io.Serializable;
import java.util.List;

import com.restful.model.Commissar;
import com.restful.model.Events;

import lombok.Data;

@Data
public class EventsListCommissar implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Events events;
	private List<Commissar> listCommisar;
}
