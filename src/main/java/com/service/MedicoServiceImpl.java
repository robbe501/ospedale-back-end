package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.MedicoDTO;
import com.entity.Medico;
import com.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository mr;

	@Override
	public ResponseEntity<List<Medico>> get() {
		return new ResponseEntity<>(mr.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(Integer medicoId) {
		try {
			mr.deleteById(medicoId);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Medico> post(MedicoDTO medicoDTO) {
		Medico medico = toEntity(medicoDTO);
		try {
			mr.save(medico);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(medico, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Medico> patch(MedicoDTO medico) {
		Optional<Medico> m = mr.findById(medico.getMedicoId());
		try {
			m.get().setAbilitato(medico.isAbilitato());
			mr.save(m.get());
			return new ResponseEntity<>(m.get(), HttpStatus.OK);
		} catch (NoSuchElementException | IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Medico toEntity(MedicoDTO medicoDTO) {
		Medico m = new Medico();
		m.setAbilitato(medicoDTO.isAbilitato());
		m.setCognome(medicoDTO.getCognome());
		m.setNome(medicoDTO.getNome());
		m.setEmail(medicoDTO.getEmail());
		return m;
	}

}
