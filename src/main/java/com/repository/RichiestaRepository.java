package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Medico;
import com.entity.Paziente;
import com.entity.Richiesta;

public interface RichiestaRepository extends JpaRepository<Richiesta, Integer> {

	// POST Richiesta

	// PATCH Richiesta (Cambio data)

	@Query("SELECT r FROM Richiesta r JOIN r.appuntamento a JOIN a.paziente p WHERE p = :paziente")
	public List<Richiesta> findByPaziente(Paziente paziente);

	@Query("SELECT r FROM Richiesta r JOIN r.appuntamento a JOIN a.prestazione p JOIN p.medico m WHERE m = :medico")
	public List<Richiesta> findByMedico(Medico medico);
}
