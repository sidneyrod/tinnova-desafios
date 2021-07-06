package com.sid.exerciciocinco.tests.web;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.apirestveiculos.dto.VeiculosDTO;
import com.sid.apirestveiculos.services.VeiculosService;
import com.sid.apirestveiculos.services.exceptions.DatabaseException;
import com.sid.apirestveiculos.services.exceptions.ResourceNotFoundException;
import com.sid.exerciciocinco.tests.factory.VeiculosFactory;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculosControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VeiculosService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private VeiculosDTO newVeiculosDTO;
	private VeiculosDTO existingVeiculosDTO;
	private List<VeiculosDTO> list;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		dependentId = 3L;
		
		newVeiculosDTO = VeiculosFactory.criarDadosVeiculosDTO(null);
		existingVeiculosDTO = VeiculosFactory.criarDadosVeiculosDTO(existingId);
		
		list = new ArrayList<>();
		
		when(service.findById(existingId)).thenReturn(existingVeiculosDTO);
		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
		
		when(service.findAll()).thenReturn(list);
		
		when(service.inserir(any())).thenReturn(existingVeiculosDTO);
		
		when(service.atualizar(eq(existingId), any())).thenReturn(existingVeiculosDTO);
		when(service.atualizar(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
		
		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
	}
	
	@Test
	public void findByIdShouldReturnVeiculosDTOWhenIdExists() throws Exception {
		ResultActions result = mockMvc.perform(get("/veiculos/{id}", existingId).accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.id").value(existingId));
	}
	
	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		ResultActions result = mockMvc.perform(get("/veiculos/{id}", nonExistingId).accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void findAllShouldReturnList() throws Exception {
		ResultActions result = mockMvc.perform(get("/veiculos").accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	@Test
	public void insertShouldReturnCreatedVeiculosDTOWhenValidData() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(newVeiculosDTO);
		
		ResultActions result = mockMvc.perform(post("/veiculos")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
	}
	
	@Test
	public void insertShouldReturnUnprocessableEntityWhenVeiculosNameIsEmpty() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(newVeiculosDTO);
		
		ResultActions result = mockMvc.perform(post("/veiculos")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void updateShouldReturnVeiculosDTOWhenIdExists() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(newVeiculosDTO);
		
		ResultActions result = mockMvc.perform(put("/veiculos/{id}", existingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.id").value(existingId));
	}
	
	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(newVeiculosDTO);
		ResultActions result = mockMvc.perform(put("/veiculos/{id}", nonExistingId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
		ResultActions result = mockMvc.perform(delete("/veiculos/{id}", existingId)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		ResultActions result = mockMvc.perform(delete("/veiculos/{id}", nonExistingId)
				.accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isNotFound());
	}
}

