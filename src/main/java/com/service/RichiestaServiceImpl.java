package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.RichiestaDTO;
import com.entity.Appuntamento;
import com.entity.Richiesta;
import com.repository.AppuntamentoRepository;
import com.repository.MedicoRepository;
import com.repository.PazienteRepository;
import com.repository.RichiestaRepository;

@Service
public class RichiestaServiceImpl implements RichiestaService {

	@Autowired
	private RichiestaRepository rr;

	@Autowired
	private AppuntamentoRepository ar;

	@Autowired
	private MedicoRepository mr;

	@Autowired
	private PazienteRepository pr;

	@Override
	public Richiesta post(RichiestaDTO richiestaDTO) {
		Richiesta richiesta = toEntity(richiestaDTO);
		try {
			richiesta.setAppuntamento(ar.findById(richiestaDTO.getAppuntamentoId()).get());
			richiesta.setMedico(mr.findById(richiestaDTO.getMedicoId()).get());
			richiesta.setPaziente(pr.findById(richiestaDTO.getPazienteId()).get());
			return rr.save(richiesta);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Può gestire le richieste di cambio data/orario fatte dai pazienti o
	// dai medici, a seguito della scelta va inviata una EMAIL(da BE) al
	// paziente e al medico(entrambi in entrambi i casi).

	@Override
	public Richiesta patch(RichiestaDTO richiestaDTO) {
		try {
			Optional<Richiesta> r = rr.findById(richiestaDTO.getRichiestaId());
			r.get().setStato(richiestaDTO.getStato());
			if (richiestaDTO.getStato() == "accettata") {
				Appuntamento a = r.get().getAppuntamento();
				a.setData(richiestaDTO.getNuovaData());
				a.setOrario(richiestaDTO.getNuovoOrario());
				ar.save(a);
			}
			rr.save(r.get());
			// TODO INVIO EMAIL
			return r.get();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Richiesta toEntity(RichiestaDTO richiestaDTO) {
		Richiesta r = new Richiesta();
		r.setNuovaData(richiestaDTO.getNuovaData());
		r.setNuovoOrario(richiestaDTO.getNuovoOrario());
		r.setStato("attesa");
		return null;
	}

	@Override
	public List<Richiesta> get() {
		return rr.findAll();
	}

}
