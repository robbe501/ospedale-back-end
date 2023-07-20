package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RichiestaDTO;
import com.entity.Richiesta;
import com.service.RichiestaService;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class RichiestaController {

	@Autowired
	private RichiestaService rs;

	@GetMapping("/richieste")
	public ResponseEntity<List<Richiesta>> get() {
		return rs.get();
	}

	@PostMapping("/richieste")
	public ResponseEntity<Richiesta> post(@RequestBody RichiestaDTO richiestaDTO) {
		System.out.println(richiestaDTO);
		return rs.post(richiestaDTO);
	}

	@PatchMapping("/richieste")
	public ResponseEntity<Richiesta> patch(@RequestBody RichiestaDTO richiestaDTO) {
		return rs.patch(richiestaDTO);
	}
}
