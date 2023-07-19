package com.service;

import java.time.LocalDate;
import java.util.List;

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;

public interface AppuntamentoService {
	// GET Appuntamenti
	public List<Appuntamento> get();

	// GET AppuntamentoByData
	public List<Appuntamento> getByData(LocalDate data);

	// POST Appuntamento
	public Appuntamento post(AppuntamentoDTO appuntamento);

	// PATCH Appuntamento (Cambio Stato)
	public Appuntamento patch(AppuntamentoDTO appuntamento);

	// GET AppuntamentiByCodiceFiscale
	public List<Appuntamento> getByPazienteId(Integer pazienteId);

}
