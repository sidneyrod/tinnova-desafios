package com.sid.apirestveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.apirestveiculos.entities.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
