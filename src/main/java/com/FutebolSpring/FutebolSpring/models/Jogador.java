package com.FutebolSpring.FutebolSpring.models;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

@Entity
public class Jogador implements Serializable  {
	
	
	//o tipo de coluna e chave primaria   e vai ser de 1 em 1
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	

	@NotEmpty
	private String nome;
	
	
	@NotEmpty
	private String gols;
	
	@NotEmpty
	private String assistencias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGols() {
		return gols;
	}

	public void setGols(String gols) {
		this.gols = gols;
	}

	public String getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(String assistencias) {
		this.assistencias = assistencias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
