package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Prestazione> get() {
		return pr.findAll();
	}

	@Override
	public Prestazione post(PrestazioneDTO prestazioneDTO) {
		try {
			Prestazione prestazione = toEntity(prestazioneDTO);
			prestazione.setMedico(mr.findById(prestazioneDTO.getMedicoId()).get());
			return pr.save(prestazione);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Prestazione patch(PrestazioneDTO prestazioneDTO) {
		try {
			Optional<Prestazione> p = pr.findById(prestazioneDTO.getPrestazioneId());
			p.get().setMedico(mr.findById(prestazioneDTO.getMedicoId()).get());
			pr.save(p.get());
			return p.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Prestazione toEntity(PrestazioneDTO prestazioneDTO) {
		Prestazione p = new Prestazione();
		p.setTipologia(prestazioneDTO.getTipologia());
		return p;
	}

}
