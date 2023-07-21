package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	// GET Medici

	// DELETE Medico

	// POST Medico

	public List<Medico> getByAbilitato(Boolean abilitato);

}
