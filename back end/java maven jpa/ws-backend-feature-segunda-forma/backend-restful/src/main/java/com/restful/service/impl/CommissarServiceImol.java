package com.restful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.model.Commissar;
import com.restful.repository.CommisarRepository;
import com.restful.service.ICommissarService;
import com.restful.util.Util;

@Service
public class CommissarServiceImol implements ICommissarService{

	@Autowired
	CommisarRepository commisarRepository;
	
	@Override
	public Commissar save(Commissar obj) {
		return commisarRepository.save(obj);
	}

	@Override
	public Commissar update(Commissar obj) {
		if(!Util.isNotNull(obj.getCommissarId())) {
			return null;
		}else {
			return commisarRepository.save(obj);
		}
	}

	@Override
	public List<Commissar> findAll() {
		return commisarRepository.findAll();
	}


}

