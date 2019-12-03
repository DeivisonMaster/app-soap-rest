package br.com.service.rest.cep;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/ceprest")
public class CEPRestWS {
	
//	@Context
//	private UriInfo context;
	
	public CEPRestWS() {
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buscaCEP/{cepParam}")
	public CEP getCep(@PathParam("cepParam") String cepParam) {
		
		CEP cep = new CEP();
		
		cep.setCep(cepParam);
		cep.setBairro("Bairro " + new Random().nextInt());
		cep.setNumero(new Random().nextInt());
		cep.setRua("Rua que sempre " + new Random().nextInt());
		cep.setUf("PR");
		
		return cep;
	}
}
