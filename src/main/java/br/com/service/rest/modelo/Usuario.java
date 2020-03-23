package br.com.service.rest.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private Integer idade;
	private String cpf;
	private List<String> frutasPreferidas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<String> getFrutasPreferidas() {
		return frutasPreferidas;
	}
	
}
