package com.restful.service;

import java.util.List;

import com.restful.model.Events;

public interface IEventsService {

	Events save(Events events);
	Events update(Events events);
	List<Events> getAll();
	Events getById(Long id);
}
