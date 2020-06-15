package com.restful.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.model.Events;
import com.restful.repository.EventsRepository;
import com.restful.service.IEventsService;
import com.restful.util.Util;

@Service
public class EventsServiceImpl implements IEventsService{

	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public Events save(Events obj) {
		return eventsRepository.save(obj);
	}

	@Override
	public Events update(Events events) {
		if(!Util.isNotNull(events.getEventId())) {
			return null;
		}else {
			return eventsRepository.save(events);
		}
	}

	@Override
	public List<Events> getAll() {
		return eventsRepository.findAll();
	}

	@Override
	public Events getById(Long id) {
		Optional<Events> op = eventsRepository.findById(id);
		return op.isPresent() ? op.get() : null;
	}
}
