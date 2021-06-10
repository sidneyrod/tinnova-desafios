package com.sid.exerciciocinco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.exerciciocinco.dto.VeiculosDTO;
import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.repository.VeiculosRepository;
import com.sid.exerciciocinco.services.exceptions.DatabaseException;
import com.sid.exerciciocinco.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository repository;

	@Transactional(readOnly = true)
	public Page<VeiculosDTO> findAllPaged(PageRequest pageRequest) {
		Page<Veiculos> list = repository.findAll(pageRequest);
		return list.map(x -> new VeiculosDTO(x));
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
		Optional<Veiculos> obj = repository.findById(id);
		Veiculos veiculos = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade " + id + " não encontrada"));
		copiaDtoParaEntidade(dto, veiculos);
		return new VeiculosDTO(veiculos);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado" + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
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
