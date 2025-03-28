package com.rest.controllers;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rest.Entity.API;
import com.rest.Entity.Employee;
import com.rest.Service.EmployeeService;

@Path("/")
public class EmployeeController {
	private static final ObjectMapper mapper = new ObjectMapper();
	private static List<Employee> employeeList = new ArrayList<>();
	static 
	{
		employeeList = EmployeeService.getInstance().getEmployeeList();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response entryPoint() {
		List<API> apiList = new ArrayList<>();
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api", "API List"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/employees", "Lists All Employee Detail"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/employee/{empId}", "List Employee Info"));
		apiList.add(new API("POST", "http://localhost:8080/JavaJerseyApi/api/employee/", "Create Employee"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/annotation;gender={value}?name={value}", "Annotation with Header,Query,Matrix,Cookie"));
		apiList.add(new API("POST", "http://localhost:8080/JavaJerseyApi/api/context/", "Get Context Info"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/subresource/firstname/{firstname}/lastname/{lastname}", "SubResource"));
		return Response.status(Response.Status.OK).entity(apiList).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employees")
	public List<Employee> getEmployees() {
		return employeeList;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employee/{empId}")
	public Response getEmployeeWithCacheControl(@PathParam("empId") @DefaultValue("0") Long empId , @Context Request request) throws Throwable {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(100);
		
		Optional<Employee> employee = Optional.ofNullable(employeeList.stream().filter( e -> e.getId()==empId).findFirst().orElse(null));
		if(employee.isEmpty())
		{
			throw new Throwable("Employee ["+empId+"] Not Found -> [404 - Not Found]");
		}
		EntityTag entityTag = new EntityTag(employee.get().getLastmodified().toString());
		Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(entityTag);
		if(responseBuilder != null)
		{
			return responseBuilder.cacheControl(cacheControl).tag(entityTag).build();
		}
		
		responseBuilder = Response.status(Response.Status.OK).cacheControl(cacheControl).tag(entityTag).entity(employee.get());
		return 	responseBuilder.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employee/")
	public Response createEmployee(Employee employee) {
		ObjectNode json = mapper.createObjectNode();
		json.put("InsertStatus", EmployeeService.getInstance().createEmployee(employee));
		return Response.status(Response.Status.CREATED).entity(json)
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/annotation/")
	public Response paramAnnotation(@QueryParam("name") String queryParam,@MatrixParam("gender") String matrixParam,
									@HeaderParam("authcode") String headerParam,@CookieParam("id") String cookieParam) {
		ObjectNode json = mapper.createObjectNode();
		json.put("Query_Param" ,queryParam);
		json.put("Matrix_Param",matrixParam);
		json.put("Header_Param",headerParam);
		json.put("Cookie_Param",cookieParam);
		return Response.status(Response.Status.OK).entity(json)
				.build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/context/")
	public Response paramAnnotation(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		ObjectNode jsonObj = mapper.createObjectNode();
		jsonObj.put("UrlInfo" ,uriInfo.getAbsolutePath().toString());
		jsonObj.put("Header's Cookies" ,headers.getCookies().get("id").getValue());
		return Response.status(Response.Status.OK).entity(jsonObj)
				.build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/subresource/firstname/{firstname}/lastname/{lastname}")
	public Response subResource(@PathParam("firstname") String firstName, @PathParam("lastname") String lastName)
	{
		ObjectNode jsonObj = mapper.createObjectNode();
		jsonObj.put("First Name" ,firstName);
		jsonObj.put("Last Name" ,lastName);
		return Response.status(Response.Status.OK).entity(jsonObj)
				.build();
	}
}
