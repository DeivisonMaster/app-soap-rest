package br.com.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class JavaRest {
	
	@GET
	@Produces("text/html")
	public String exemplo() {
		return "<html lang=\"en\"><body><h1>Hello, World!!</body></h1></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("digaOla/{msg}")
	public String digaOla(@PathParam(value = "msg") String msg) {
		return "Olá " + msg;
	}
	
}















