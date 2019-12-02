package br.com.service.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/usuario")  // caminho pelo qual o serviço REST irá responder
public class CrudUsuarioRest {
	
	@Path("/")
	@GET // select
	@Produces("application/json")  // tipo de dado de retorno
	public Response getUser(@PathParam("id") String id) {
		// simulando busca por usuário
		
		System.out.println("buscando usuario: " + id);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Deivison");
		usuario.setCpf("111.222.333-22");
		usuario.setIdade(27);
		
		List<String> minhasFrutas = Arrays.asList("Maca", "Banana", "Caju", "Pera");
		usuario.getFrutasPreferidas().addAll(minhasFrutas);
		
		return Response.status(200).entity(usuario).build();
	}
	
	
	@POST  // insert
	@Consumes("application/json")
	@Produces("application/json")
	public Response createUser(Usuario usuario) {
		// simula iserção no banco
		
		System.out.println("Criando usuário");
		return Response.status(200).entity(usuario).build();
	}
	
	@Path("/")
	@PUT  // update
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateUser(@PathParam("id") String id, Usuario usuario) {
		// simula update em um registro no banco

		System.out.println("Atualizando usuário: " + id);
		return Response.status(200).entity(usuario).build();
	}
	
	@Path("/")
	@DELETE  // delete
	public Response deleteUser(@PathParam("id") String id) {
		// simula exclusão de registro
		
		System.out.println("Excluindo registro de usuário " + id);
		return Response.status(200).build();
	}
	
}























