package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;
import com.service.AppuntamentoService;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class AppuntamentoController {

	@Autowired
	AppuntamentoService as;

	@GetMapping("/appuntamenti")
	public List<Appuntamento> get() {
		return as.get();
	}

	@GetMapping("/appuntamenti/{data}")
	public List<Appuntamento> getByData(@PathVariable LocalDate data) {
		return as.getByData(data);
	}

	@GetMapping("/appuntamenti/paziente/{pazienteId}")
	public List<Appuntamento> getByCodiceFiscale(@PathVariable Integer pazienteId) {
		return as.getByPazienteId(pazienteId);
	}

	@PostMapping("/appuntamenti")
	public Appuntamento post(@RequestBody AppuntamentoDTO appuntamento) {
		return as.post(appuntamento);
	}

	@PatchMapping("/appuntamenti")
	public Appuntamento patch(@RequestBody AppuntamentoDTO appuntamento) {
		return as.patch(appuntamento);
	}
}
