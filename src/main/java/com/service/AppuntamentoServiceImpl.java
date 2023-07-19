package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Appuntamento> get() {
		return ar.findAll();
	}

	@Override
	public List<Appuntamento> getByData(LocalDate data) {
		return ar.findByData(data);
	}

	@Override
	public Appuntamento post(AppuntamentoDTO appuntamentoDTO) {
		try {
			Appuntamento a = toEntity(appuntamentoDTO);
			a.setPaziente(pazienteRepo.findById(appuntamentoDTO.getPazienteId()).get());
			ar.save(a);
			return a;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Appuntamento patch(AppuntamentoDTO appuntamento) {
		Optional<Appuntamento> a = ar.findById(appuntamento.getAppuntamentoId());
		try {
			a.get().setStato(appuntamento.getStato());
			ar.save(a.get());
			return a.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
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

	@Override
	public List<Appuntamento> getByPazienteId(Integer pazienteId) {
		return ar.findByPaziente(pazienteRepo.findById(pazienteId).get());
	}
}
