package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.AppuntamentoDTO;
import com.entity.Appuntamento;
import com.repository.AppuntamentoRepository;
import com.repository.PazienteRepository;
import com.repository.PrestazioneRepository;

@Service
public class AppuntamentoServiceImpl implements AppuntamentoService {

	@Autowired
	AppuntamentoRepository ar;

	@Autowired
	PrestazioneRepository pr;

	@Autowired
	PazienteRepository pazienteRepo;

	@Override
	public ResponseEntity<List<Appuntamento>> get() {
		return new ResponseEntity<>(ar.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Appuntamento>> getByData(LocalDate data) {
		return new ResponseEntity<>(ar.findByData(data), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Appuntamento> post(AppuntamentoDTO appuntamentoDTO) {
		try {
			Appuntamento a = toEntity(appuntamentoDTO);
			a.setPaziente(pazienteRepo.findById(appuntamentoDTO.getPazienteId()).get());
			ar.save(a);
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		} catch (NoSuchElementException | IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Appuntamento> patch(AppuntamentoDTO appuntamento) {
		Optional<Appuntamento> a = ar.findById(appuntamento.getAppuntamentoId());
		try {
			a.get().setStato(appuntamento.getStato());
			ar.save(a.get());
			return new ResponseEntity<>(a.get(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Appuntamento>> getByPazienteId(Integer pazienteId) {
		return new ResponseEntity<>(ar.findByPaziente(pazienteRepo.findById(pazienteId).get()), HttpStatus.OK);
	}

	private Appuntamento toEntity(AppuntamentoDTO appuntamentoDTO) {
		Appuntamento a = new Appuntamento();
		a.setCodiceFiscale(appuntamentoDTO.getCodiceFiscale());
		a.setData(appuntamentoDTO.getData());
		a.setRicetta(appuntamentoDTO.getRicetta());
		a.setStato(appuntamentoDTO.getStato());
		a.setOrario(appuntamentoDTO.getOrario());
		a.setPrestazione(pr.findById(appuntamentoDTO.getPrestazioneId()).get());
		return a;
	}
}
