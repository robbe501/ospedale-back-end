package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.PrestazioneDTO;
import com.entity.Prestazione;
import com.repository.MedicoRepository;
import com.repository.PrestazioneRepository;

@Service
public class PrestazioneServiceImpl implements PrestazioneService {

	@Autowired
	private PrestazioneRepository pr;

	@Autowired
	private MedicoRepository mr;

	@Override
	public ResponseEntity<List<Prestazione>> get() {
		return new ResponseEntity<>(pr.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Prestazione> post(PrestazioneDTO prestazioneDTO) {
		try {
			Prestazione prestazione = toEntity(prestazioneDTO);
			prestazione.setMedico(mr.findById(prestazioneDTO.getMedicoId()).get());
			return new ResponseEntity<>(pr.save(prestazione), HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Prestazione> patch(PrestazioneDTO prestazioneDTO) {
		try {
			Optional<Prestazione> p = pr.findById(prestazioneDTO.getPrestazioneId());
			p.get().setMedico(mr.findById(prestazioneDTO.getMedicoId()).get());
			pr.save(p.get());
			return new ResponseEntity<>(p.get(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Prestazione toEntity(PrestazioneDTO prestazioneDTO) {
		Prestazione p = new Prestazione();
		p.setTipologia(prestazioneDTO.getTipologia());
		return p;
	}

}
