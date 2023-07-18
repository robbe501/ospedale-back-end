package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Medico> get() {
		return ms.get();
	}

	@PostMapping("/medici")
	public Medico post(@RequestBody MedicoDTO medico) {
		return ms.post(medico);
	}

	@PatchMapping("/medici")
	public Medico patch(@RequestBody MedicoDTO medico) {
		return ms.patch(medico);
	}

	@DeleteMapping("/medici/{medicoId}")
	public void patch(@PathVariable Integer medicoId) {
		ms.delete(medicoId);
	}
}
