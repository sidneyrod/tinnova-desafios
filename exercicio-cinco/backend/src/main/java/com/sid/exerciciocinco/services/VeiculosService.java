package com.sid.exerciciocinco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.repository.VeiculosRepository;
import com.sid.exerciciocinco.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;

	@Transactional(readOnly = true)
	public Page<Veiculos> findAllPaged(PageRequest pageRequest) {
		Page<Veiculos> list = repository.findAll(pageRequest);
		return list;
	}

	@Transactional(readOnly = true)
	public Veiculos findById(Long id) {
		Optional<Veiculos> obj = repository.findById(id);
		Veiculos veiculos = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade " + id + " não encontrada"));
		return veiculos;
	}

	@Transactional
	public Veiculos inserir(Veiculos veiculos) {
		veiculos = repository.save(veiculos);
		return veiculos;
	}

	@Transactional
	public Veiculos atualizar(Long id, Veiculos veiculos) {
		Optional<Veiculos> obj = repository.findById(id);
		veiculos = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade " + id + " não encontrada"));
		veiculos.setVeiculo(veiculos.getVeiculo());
		veiculos.setMarca(veiculos.getMarca());
		veiculos.setAno(veiculos.getAno());
		veiculos.setDescricao(veiculos.getDescricao());
		veiculos.setVendido(veiculos.getVendido());
		veiculos = repository.save(veiculos);
		return veiculos;
	}
}
