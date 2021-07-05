package com.sid.exerciciocinco.tests.factory;

import com.sid.apirestveiculos.dto.VeiculosDTO;
import com.sid.apirestveiculos.entities.Veiculos;
import com.sid.apirestveiculos.entities.enums.StatusVendaVeiculo;

public class VeiculosFactory {
	
	public static Veiculos criarDadosVeiculos() {
		return new Veiculos(1L, "SPIN", "CHEVROLET", 2020, "CHEVROLET SPIN 2020 LTZ, 1.4, COMPLETO", StatusVendaVeiculo.NAO);
	}
	
	public static VeiculosDTO criarDadosVeiculosDTO() {
		return new VeiculosDTO(criarDadosVeiculos());
	}
	
	public static VeiculosDTO criarDadosVeiculosDTO(Long id) {
		VeiculosDTO dto = criarDadosVeiculosDTO();
		dto.setId(id);
		return dto;
	}
}
