package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;

public interface RichiestaService {

	// GET Richieste
	public ResponseEntity<List<Richiesta>> get();

	// GET RichiesteByPazienteId
	public ResponseEntity<List<Richiesta>> getByPazienteId(Integer pazienteId);

	public ResponseEntity<List<Richiesta>> getByMedicoId(Integer medicoId);

	// POST Richiesta
	public ResponseEntity<Richiesta> post(RichiestaDTO richiestaDTO);

	// PATCH Richiesta (Cambio data)
	public ResponseEntity<Richiesta> patch(RichiestaDTO richiesta);
}
