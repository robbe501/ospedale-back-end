package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paziente_id")
	private Integer pazienteId;

	private String nome;

	private String cognome;

	private String email;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;
}
