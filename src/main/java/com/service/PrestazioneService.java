package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;

public interface PrestazioneService {
	// GET Prestazioni
	public ResponseEntity<List<Prestazione>> get();

	// POST Prestazione
	public ResponseEntity<Prestazione> post(PrestazioneDTO prestazioneDTO);

	// PATCH Prestazione (Cambio Medico)
	public ResponseEntity<Prestazione> patch(PrestazioneDTO prestazioneDTO);
}
