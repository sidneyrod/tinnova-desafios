package com.sid.exerciciocinco.dto;

import java.io.Serializable;

import com.sid.exerciciocinco.entities.Veiculos;
import com.sid.exerciciocinco.entities.enums.StatusVendaVeiculo;

public class VeiculosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private StatusVendaVeiculo vendido;
	
	public VeiculosDTO() {
	}

	public VeiculosDTO(Long id, String veiculo, String marca, Integer ano, String descricao,
			StatusVendaVeiculo vendido) {
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}
	
	public VeiculosDTO(Veiculos entidade) {
		id = entidade.getId();
		veiculo = entidade.getVeiculo();
		marca = entidade.getMarca();
		ano = entidade.getAno();
		descricao = entidade.getDescricao();
		vendido = entidade.getVendido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusVendaVeiculo getVendido() {
		return vendido;
	}

	public void setVendido(StatusVendaVeiculo vendido) {
		this.vendido = vendido;
	}
}
