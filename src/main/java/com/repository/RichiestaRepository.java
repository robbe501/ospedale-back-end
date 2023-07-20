package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Medico;
import com.entity.Paziente;
import com.entity.Richiesta;

public interface RichiestaRepository extends JpaRepository<Richiesta, Integer> {

	// POST Richiesta

	// PATCH Richiesta (Cambio data)

	public List<Richiesta> findByPaziente(Paziente paziente);

	public List<Richiesta> findByMedico(Medico medico);
}
