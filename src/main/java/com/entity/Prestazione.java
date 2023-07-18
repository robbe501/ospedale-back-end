package com.entity;

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
public class Prestazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prestazione_id")
	private Integer prestazioneId;

	private String tipologia;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

}
