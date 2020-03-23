package br.com.service.rest.modelo;

import javax.xml.bind.annotation.XmlElement;

public class Musica {
	
	@XmlElement
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
