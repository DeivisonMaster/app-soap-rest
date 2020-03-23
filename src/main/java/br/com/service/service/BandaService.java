package br.com.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.service.rest.modelo.Album;
import br.com.service.rest.modelo.Banda;
import br.com.service.rest.modelo.Musica;

@Path("/bandaService")
public class BandaService {
	
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_XML)
	public Banda getUsuarioNoXML() {
		Banda banda = new Banda();
		banda.setNome("Charlie Brown Jr");
		
		Album album = new Album();
		album.setAno(1997);
		album.setNome("Transpiração Contínua e Prolongada");
		
		Musica m1 = new Musica();
		m1.setNome("O Coro vai comê");
		
		Musica m2 = new Musica();
		m2.setNome("Aquela Paz");
		
		List<Musica> musicas = new ArrayList<>();
		musicas.add(m1);
		musicas.add(m2);
		
		album.setMusicas(musicas);
		
		banda.setAlbum(album);
		
		return banda;
	}
}















































