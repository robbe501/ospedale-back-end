package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.MedicoDTO;
import com.entity.Medico;
import com.service.MedicoService;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class MedicoController {

	@Autowired
	MedicoService ms;

	@GetMapping("/medici")
	public ResponseEntity<List<Medico>> get() {
		return ms.get();
	}

	@GetMapping("/medici/abilitati")
	public ResponseEntity<List<Medico>> getByAbilitato() {
		return ms.getByAbilitato(true);
	}

	@PostMapping("/medici")
	public ResponseEntity<Medico> post(@RequestBody MedicoDTO medico) {
		return ms.post(medico);
	}

	@PatchMapping("/medici")
	public ResponseEntity<Medico> patch(@RequestBody MedicoDTO medico) {
		return ms.patch(medico);
	}

	@DeleteMapping("/medici/{medicoId}")
	public ResponseEntity<String> patch(@PathVariable Integer medicoId) {
		return ms.delete(medicoId);
	}
}
