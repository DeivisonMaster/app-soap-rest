package br.com.service.service;

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

import br.com.service.rest.modelo.Usuario;

@Path("/usuario")  // caminho pelo qual o serviço REST irá responder
public class CrudUsuarioRest {
	private static int contador = 3;
	private Map<Integer, Usuario> usuarios = new HashMap<>();
	private Map<String, Usuario> usuariosNome = new HashMap<>();
	
	
	public CrudUsuarioRest() {
		
	}
	
	public void cadastraUsuarios() {
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
	}
	
	
	@Path("buscaUsuario")
	@GET // select
	@Produces(MediaType.APPLICATION_JSON)  // tipo de dado de retorno
	public Map<Integer, Usuario> getAllUsers() {
		// simulando busca por usuário
		
		cadastraUsuarios();
		
		//return Response.status(200).entity(usuario).build();
		return this.usuarios;
	}
	
	
	@GET
	@Path("buscaPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getById(@PathParam("id") Integer id) {
		Usuario usuario = usuarios.get(id);
		
		if(usuario != null) {
			return usuario;
		}
		
		return usuario;
	}
	
	@GET
	@Path("buscaPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getByName(@PathParam("nome") String nome) {
		Usuario user = new Usuario();
		
		user.setNome("Marcos");
		user.setCpf("222.111.555.33");
		user.setIdade(28);
		
		usuariosNome.put("nome1", user);
		Usuario usuario = usuariosNome.get(nome);
		
		return usuario; 
	}
	
	@POST  // insert
	@Path("cadastraUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Map<Integer, Usuario> createUser(Usuario usuario) {
		// simula iserção no banco
		
		this.usuarios.put(++contador, usuario);
		
		System.out.println("Criando usuário");
		return this.usuarios;
	}
	
	@Path("atualizaUsuario/{id}")
	@PUT  // update
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") String id, Usuario usuario) {
		// simula update em um registro no banco

		System.out.println("Atualizando usuário: " + id);
		return Response.status(200).entity(usuario).build();
	}
	
	@DELETE  // delete
	@Path("excluiUsuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Integer, Usuario> deleteUser(@PathParam("id") Integer id) {
		// simula exclusão de registro
		
		Usuario usuario = this.usuarios.get(id);
		if(usuario != null) {
			this.usuarios.remove(id);
		}
		
		//return Response.status(200).build();
		return this.usuarios;
	}
	
}























