package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Richiesta> post(RichiestaDTO richiestaDTO) {
		Richiesta richiesta = toEntity(richiestaDTO);
		try {
			richiesta.setAppuntamento(ar.findById(richiestaDTO.getAppuntamentoId()).get());
//			richiesta.setMedico(mr.findById(richiestaDTO.getMedicoId()).get());
//			richiesta.setPaziente(pr.findById(richiestaDTO.getPazienteId()).get());
			return new ResponseEntity<>(rr.save(richiesta), HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Può gestire le richieste di cambio data/orario fatte dai pazienti o
	// dai medici, a seguito della scelta va inviata una EMAIL(da BE) al
	// paziente e al medico(entrambi in entrambi i casi).

	@Override
	public ResponseEntity<Richiesta> patch(RichiestaDTO richiestaDTO) {
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
			return new ResponseEntity<>(r.get(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Richiesta toEntity(RichiestaDTO richiestaDTO) {
		Richiesta r = new Richiesta();
		r.setNuovaData(richiestaDTO.getNuovaData());
		r.setNuovoOrario(richiestaDTO.getNuovoOrario());
		r.setStato("attesa");
		return r;
	}

	@Override
	public ResponseEntity<List<Richiesta>> get() {
		try {
			return new ResponseEntity<>(rr.findAll(), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Richiesta>> getByPazienteId(Integer pazienteId) {
		try {
			return new ResponseEntity<>(rr.findByPaziente(pr.findById(pazienteId).get()), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Richiesta>> getByMedicoId(Integer medicoId) {
		try {
			return new ResponseEntity<>(rr.findByMedico(mr.findById(medicoId).get()), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
