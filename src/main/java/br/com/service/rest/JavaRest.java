package br.com.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/rest")
public class JavaRest {
	
	@GET
	@Produces("text/html")
	public String exemplo() {
		return "<html lang=\"en\"><body><h1>Hello, World!!</body></h1></html>";
	}
}















