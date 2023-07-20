package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Appuntamento;
import com.entity.Medico;
import com.entity.Paziente;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Integer> {
	// GET Appuntamenti

	// GET AppuntamentoByData
	public List<Appuntamento> findByData(LocalDate data);

	public List<Appuntamento> findByPaziente(Paziente paziente);

	@Query("SELECT a FROM Appuntamento a JOIN a.prestazione p JOIN p.medico m WHERE m = :medico")
	public List<Appuntamento> findByMedico(Medico medico);

	// POST Appuntamento

	// PATCH Appuntamento (Cambio Stato)
}
