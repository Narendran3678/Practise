package com.java.controllers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HomeController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/")
	public String entryPoint()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("http://localhost:8080/JavaJerseyApi/api").append("\n");
		return sb.toString();
	}
}
