package com.service;

import java.util.List;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;

public interface RichiestaService {

	// GET Richieste
	public List<Richiesta> get();

	// POST Richiesta
	public Richiesta post(RichiestaDTO richiestaDTO);

	// PATCH Richiesta (Cambio data)
	public Richiesta patch(RichiestaDTO richiesta);
}
