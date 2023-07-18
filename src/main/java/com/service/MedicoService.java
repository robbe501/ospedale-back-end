package com.service;

import java.util.List;

import com.dto.MedicoDTO;
import com.entity.Medico;

public interface MedicoService {

	// GET Medici
	public List<Medico> get();

	// DELETE Medico
	public void delete(Integer medicoId);

	// POST Medico
	public Medico post(MedicoDTO medicoDTO);

	// PATCH Medico (Cambio abilitato)
	public Medico patch(MedicoDTO medicoDTO);

}
