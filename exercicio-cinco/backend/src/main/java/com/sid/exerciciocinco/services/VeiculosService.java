package com.sid.exerciciocinco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.repository.VeiculosRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;
	
	public List<Veiculos> findAll() {
		List<Veiculos> list = repository.findAll();
		return list;
	}
	
}
