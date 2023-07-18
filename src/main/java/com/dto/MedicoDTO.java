package com.dto;

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
public class MedicoDTO {

	private Integer medicoId;
	private String nome;
	private String cognome;
	private String email;
	private boolean abilitato;
}
