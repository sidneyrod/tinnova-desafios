package com.sid.exerciciocinco.tests.integration;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sid.apirestveiculos.dto.VeiculosDTO;
import com.sid.apirestveiculos.services.VeiculosService;
import com.sid.apirestveiculos.services.exceptions.ResourceNotFoundException;

@SpringBootTest
@Transactional
public class VeiculosIT {

	@Autowired
	private VeiculosService service;
	
	private long existingId;
	private long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
	} 
	
	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});
	}
	
	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});
	}
	
	@Test
	public void findByIdShouldReturnVeiculosDTOWhenIdExists() {
		VeiculosDTO result = service.findById(existingId);
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});
	}
	
	@Test
	public void findAllShouldReturnVeiculosDTOWhenIdExists() {
		List<VeiculosDTO> result = service.findAll();
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void updateShouldReturnVeiculosDTOWhenIdExists() {
		VeiculosDTO dto = new VeiculosDTO();
		VeiculosDTO result = service.atualizar(existingId, dto);
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		VeiculosDTO dto = new VeiculosDTO(); 
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.atualizar(nonExistingId, dto);
		});
	}
}

