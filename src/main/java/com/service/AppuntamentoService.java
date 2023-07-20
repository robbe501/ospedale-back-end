package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;

public interface AppuntamentoService {
	// GET Appuntamenti
	public ResponseEntity<List<Appuntamento>> get();

	// GET AppuntamentoByData
	public ResponseEntity<List<Appuntamento>> getByData(LocalDate data);

	// POST Appuntamento
	public ResponseEntity<Appuntamento> post(AppuntamentoDTO appuntamento);

	// PATCH Appuntamento (Cambio Stato)
	public ResponseEntity<Appuntamento> patch(AppuntamentoDTO appuntamento);

	// GET AppuntamentiByCodiceFiscale
	public ResponseEntity<List<Appuntamento>> getByPazienteId(Integer pazienteId);

}
