package com.sid.apirestveiculos.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sid.apirestveiculos.dto.VeiculosDTO;
import com.sid.apirestveiculos.services.VeiculosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/veiculos")
@Api(value = "API REST Veículos")
@CrossOrigin(origins = "*")
public class VeiculosController {
	
	@Autowired
	private VeiculosService service;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos")
	public ResponseEntity<List<VeiculosDTO>> findAll() {
	List<VeiculosDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um veículo único")
	public ResponseEntity<VeiculosDTO> findById(@PathVariable Long id) {
		VeiculosDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva um veículo")
	public ResponseEntity<VeiculosDTO> inserir(@Valid @RequestBody VeiculosDTO dto) {
		dto = service.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Atualiza um veículo")
	public ResponseEntity<VeiculosDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculosDTO dto) {
		dto = service.atualizar(id, dto);		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deleta um veículo")
	public ResponseEntity<VeiculosDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
