package com.sid.exerciciocinco.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.sid.exerciciocinco.entities.enums.StatusVendaVeiculo;

@Entity
@Table(name = "tb_veiculos")
public class Veiculos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String veiculo;
	private String marca;
	private String ano;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusVendaVeiculo vendido;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant created;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updated;

	public Veiculos() {
	}

	public Veiculos(Long id, String veiculo, String marca, String ano, String descricao, StatusVendaVeiculo vendido) {
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
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

	@PrePersist
	public void prePersist() {
		created = Instant.now();
	}

	@PreUpdate
	public void preUpdate() {
		updated = Instant.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculos other = (Veiculos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}