package br.com.service.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")  // caminho pelo qual o serviço REST irá responder
public class CrudUsuarioRest {
	
	@Path("buscaUsuario/{id}")
	@GET // select
	@Produces(MediaType.APPLICATION_JSON)  // tipo de dado de retorno
	public Usuario getUser(@PathParam("id") Integer id) {
		// simulando busca por usuário
		
		Map<Integer, Usuario> usuarios = new HashMap<>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Deivison");
		usuario1.setCpf("111.222.333-22");
		usuario1.setIdade(27);
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Victor");
		usuario2.setCpf("777.223.113.54");
		usuario2.setIdade(29);
		
		Usuario usuario3 = new Usuario();
		usuario3.setNome("Marcus");
		usuario3.setCpf("333.222.111-00");
		usuario3.setIdade(37);
		
		List<String> minhasFrutas = Arrays.asList("Maca", "Banana", "Caju", "Pera");
		usuario1.getFrutasPreferidas().addAll(minhasFrutas);
		usuario2.getFrutasPreferidas().addAll(minhasFrutas);
		usuario3.getFrutasPreferidas().addAll(minhasFrutas);
		
		usuarios.put(1, usuario1);
		usuarios.put(2, usuario2);
		usuarios.put(3, usuario3);
		
		Usuario usuario = usuarios.get(id);
		
		if(usuario != null) {
			return usuario;
		}
		
		//return Response.status(200).entity(usuario).build();
		return usuario;
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























