package br.com.service.soap;

import javax.jws.Oneway;
import javax.jws.WebService;

@WebService
public class NotificacaoSoap {
	
	@Oneway
	public void notifica(Mensagem mensagem) {
		System.out.println("Mensagem recebida: " + mensagem.getPayload());
	}
}	
