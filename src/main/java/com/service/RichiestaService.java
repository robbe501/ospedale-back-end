package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;

public interface RichiestaService {

	// GET Richieste
	public ResponseEntity<List<Richiesta>> get();

	// POST Richiesta
	public ResponseEntity<Richiesta> post(RichiestaDTO richiestaDTO);

	// PATCH Richiesta (Cambio data)
	public ResponseEntity<Richiesta> patch(RichiestaDTO richiesta);
}
