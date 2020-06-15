package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.Commissar;
import com.restful.service.ICommissarService;

@RestController
@RequestMapping("/commissar")
public class CommissarContorller {

	@Autowired
	private ICommissarService commissarService;

	@PostMapping("/save")
	public Commissar save(@RequestBody Commissar obj) {
		return commissarService.save(obj);
	}
	
	@PutMapping("/update")
	public Commissar update(@RequestBody Commissar obj) {
		return commissarService.update(obj);
	}

	@GetMapping("/get")
	public List<Commissar> findAll() {
		return commissarService.findAll();
	}

}

