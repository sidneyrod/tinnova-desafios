package com.sid.exerciciocinco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.services.VeiculosService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosController {
	
	@Autowired
	private VeiculosService service;
	
	@GetMapping
	public ResponseEntity<Page<Veiculos>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<Veiculos> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
}
