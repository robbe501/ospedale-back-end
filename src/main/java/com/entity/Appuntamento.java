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
public class Appuntamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appuntamento_id")
	private Integer appuntamentoId;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	private String ricetta;
	private String stato;
	private LocalDate data;
	private Time orario;

	@ManyToOne
	@JoinColumn(name = "prestazione_id")
	private Prestazione prestazione;
}
