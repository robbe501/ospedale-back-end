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
public class AppuntamentoDTO {

	private Integer appuntamentoId;
	private String codiceFiscale;
	private String ricetta;
	private String stato;
	private LocalDate data;
	private Time orario;
	private Integer prestazioneId;
}
