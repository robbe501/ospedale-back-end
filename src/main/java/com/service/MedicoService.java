package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.MedicoDTO;
import com.entity.Medico;

public interface MedicoService {

	// GET Medici
	public ResponseEntity<List<Medico>> get();

	// DELETE Medico
	public ResponseEntity<String> delete(Integer medicoId);

	// POST Medico
	public ResponseEntity<Medico> post(MedicoDTO medicoDTO);

	// PATCH Medico (Cambio abilitato)
	public ResponseEntity<Medico> patch(MedicoDTO medicoDTO);

}
