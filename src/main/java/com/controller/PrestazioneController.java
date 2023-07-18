package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;
import com.service.PrestazioneService;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class PrestazioneController {

	@Autowired
	PrestazioneService ps;

	@GetMapping("/prestazioni")
	public List<Prestazione> get() {
		return ps.get();
	}

	@PostMapping("/prestazioni")
	public Prestazione post(@RequestBody PrestazioneDTO prestazioneDTO) {
		return ps.post(prestazioneDTO);
	}

	@PatchMapping("/prestazioni")
	public Prestazione patch(@RequestBody PrestazioneDTO prestazioneDTO) {
		return ps.patch(prestazioneDTO);
	}

}
