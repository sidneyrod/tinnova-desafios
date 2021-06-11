package com.sid.apirestveiculos.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sid.apirestveiculos.entities.Veiculos;
import com.sid.apirestveiculos.entities.enums.StatusVendaVeiculo;

public class VeiculosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	@NotBlank(message = "Informe o nome do veículo")
	private String veiculo;
	
	@NotNull
	@NotBlank(message = "Informe a marca do veículo")
	private String marca;
	
	@NotNull(message = "O ano deve ser informado")
	@Digits(integer = 4, fraction = 0, message = "O ano deve possuir 4 dígitos, Ex: yyyy")
	private Integer ano;
	
	@NotNull
	@NotBlank(message = "Informe a descrição do veículo")
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
