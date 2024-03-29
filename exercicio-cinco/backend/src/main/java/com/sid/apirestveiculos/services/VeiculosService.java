package com.sid.apirestveiculos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.apirestveiculos.dto.VeiculosDTO;
import com.sid.apirestveiculos.entities.Veiculos;
import com.sid.apirestveiculos.repository.VeiculosRepository;
import com.sid.apirestveiculos.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;

	@Transactional(readOnly = true)
	public List<VeiculosDTO> findAll() {
		List<Veiculos> list = repository.findAll();
		return list.stream().map(x -> new VeiculosDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public VeiculosDTO findById(Long id) {
		Optional<Veiculos> obj = repository.findById(id);
		Veiculos veiculos = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade " + id + " não encontrada"));
		return new VeiculosDTO(veiculos);
	}

	@Transactional
	public VeiculosDTO inserir(VeiculosDTO dto) {
		Veiculos veiculos = new Veiculos();
		copiaDtoParaEntidade(dto, veiculos);
		veiculos = repository.save(veiculos);
		return new VeiculosDTO(veiculos);
	}

	@Transactional
	public VeiculosDTO atualizar(Long id, VeiculosDTO dto) {
		try {
			Veiculos veiculos = repository.getById(id);
			copiaDtoParaEntidade(dto, veiculos);
			return new VeiculosDTO(veiculos);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entidade " + id + " não encontrada");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		}
	}
	
	public void copiaDtoParaEntidade(VeiculosDTO dto, Veiculos entidade) {
		entidade.setVeiculo(dto.getVeiculo());
		entidade.setMarca(dto.getMarca());
		entidade.setAno(dto.getAno());
		entidade.setDescricao(dto.getDescricao());
		entidade.setVendido(dto.getVendido());
	}
}
