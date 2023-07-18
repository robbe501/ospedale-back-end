package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.MedicoDTO;
import com.entity.Medico;
import com.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository mr;

	@Override
	public List<Medico> get() {
		return mr.findAll();
	}

	@Override
	public void delete(Integer medicoId) {
		mr.deleteById(medicoId);

	}

	@Override
	public Medico post(MedicoDTO medicoDTO) {
		Medico medico = toEntity(medicoDTO);
		return mr.save(medico);
	}

	@Override
	public Medico patch(MedicoDTO medico) {
		Optional<Medico> m = mr.findById(medico.getMedicoId());
		try {
			m.get().setAbilitato(medico.isAbilitato());
			mr.save(m.get());
			return m.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
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
