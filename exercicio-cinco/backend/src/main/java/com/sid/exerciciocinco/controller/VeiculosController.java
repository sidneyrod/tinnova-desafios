package com.sid.exerciciocinco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.services.VeiculosService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosController {
	
	@Autowired
	private VeiculosService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> findAll() {
		List<Veiculos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
