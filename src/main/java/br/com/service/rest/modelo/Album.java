package br.com.service.rest.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Album {
	
	@XmlElement(name = "nomeAlbum")
	private String nome;
	
	@XmlElement
	private int ano;
	
	@XmlElement
	@XmlElementWrapper
	private List<Musica> musicas;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	
	
	
}
