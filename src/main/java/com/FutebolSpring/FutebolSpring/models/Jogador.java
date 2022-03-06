package com.FutebolSpring.FutebolSpring.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String nome;
	
	
	@NotEmpty
	private long gols;
	
	@NotEmpty
	private long assistencias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		nome = nome;
	}

	public long getGols() {
		return gols;
	}

	public void setGols(long gols) {
		this.gols = gols;
	}

	public long getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(long assistencias) {
		this.assistencias = assistencias;
	}

	public long getId() {
		return id;
	}

	
}
