package com.rest.exception;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.rest.Entity.ErrorMessage;

@Provider
public class GenericException extends Throwable implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 1L;
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage message = new ErrorMessage("500",exception.getMessage(),"https://docs.oracle.com/cd/E19776-01/820-4867/ggnyk/index.html");
		System.out.println(message);
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).type(MediaType.APPLICATION_JSON).build();
	}
}
