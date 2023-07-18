package com.entity;

import java.sql.Time;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Richiesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "richiesta_id")
	private Integer richiestaId;

	private String stato;

	@Column(name = "nuova_data")
	private LocalDate nuovaData;

	@Column(name = "nuovo_orario")
	private Time nuovoOrario;

	@ManyToOne
	@JoinColumn(name = "paziente_id")
	private Paziente paziente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "appuntamento_id")
	private Appuntamento appuntamento;

}
