package com.dto;

import java.sql.Time;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

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

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RichiestaDTO {

	private Integer richiestaId;

	private String stato;

	private LocalDate nuovaData;

	private Time nuovoOrario;

	private Integer pazienteId;

	private Integer medicoId;

	private Integer appuntamentoId;

}
