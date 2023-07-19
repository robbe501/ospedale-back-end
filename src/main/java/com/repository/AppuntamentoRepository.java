package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Appuntamento;
import com.entity.Paziente;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Integer> {
	// GET Appuntamenti

	// GET AppuntamentoByData
	public List<Appuntamento> findByData(LocalDate data);

	public List<Appuntamento> findByPaziente(Paziente paziente);

	// POST Appuntamento

	// PATCH Appuntamento (Cambio Stato)
}
