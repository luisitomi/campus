package com.restful.service;

import java.util.List;

import com.restful.model.Commissar;

public interface ICommissarService {

	Commissar save(Commissar obj);
	Commissar update(Commissar obj);
	List<Commissar> findAll();
}
