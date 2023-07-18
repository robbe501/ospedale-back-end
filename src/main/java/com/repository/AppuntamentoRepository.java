package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Appuntamento;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Integer> {
	// GET Appuntamenti

	// GET AppuntamentoByData
	public List<Appuntamento> findByData(LocalDate data);

	// POST Appuntamento

	// PATCH Appuntamento (Cambio Stato)
}
