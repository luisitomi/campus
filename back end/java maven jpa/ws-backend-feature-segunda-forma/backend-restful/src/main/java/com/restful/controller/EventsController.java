package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.Events;
import com.restful.service.IEventsService;

@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	private IEventsService eventsService;
	
	@PostMapping("/save")
	public Events save(@RequestBody Events obj) {
		return eventsService.save(obj);
	}
	
	@PutMapping("/update")
	public Events update(@RequestBody Events obj) {
		return eventsService.update(obj);
	}
	
	@GetMapping("/get")
	public List<Events> findAll(){
		return eventsService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Events getById(@PathVariable Long id) {
		return eventsService.getById(id);
	}
}
