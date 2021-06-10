package com.sid.exerciciocinco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.repository.VeiculosRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;
	
	@Transactional(readOnly = true)
	public Page<Veiculos> findAllPaged(PageRequest pageRequest) {
		Page<Veiculos> list = repository.findAll(pageRequest);
		return list;
	}
	
}
