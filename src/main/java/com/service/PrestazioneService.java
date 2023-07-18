package com.service;

import java.util.List;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;

public interface PrestazioneService {
	// GET Prestazioni
	public List<Prestazione> get();

	// POST Prestazione
	public Prestazione post(PrestazioneDTO prestazioneDTO);

	// PATCH Prestazione (Cambio Medico)
	public Prestazione patch(PrestazioneDTO prestazioneDTO);
}
