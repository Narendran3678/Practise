package com.java.controllers;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.java.Entity.API;
import com.java.Entity.Employee;
import com.java.Service.EmployeeService;

@Path("/")
public class EmployeeController {
	private static final ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response entryPoint() {
		List<API> apiList = new ArrayList<>();
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api", "API List"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/employees", "Lists All Employee Detail"));
		apiList.add(new API("GET", "http://localhost:8080/JavaJerseyApi/api/employee/{empId}", "List Employee Info"));
		apiList.add(new API("POST", "http://localhost:8080/JavaJerseyApi/api/employee/", "Create Employee"));
		return Response.status(Response.Status.OK).entity(apiList).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employees")
	public Response getEmployees() {
		return Response.status(Response.Status.OK).entity(EmployeeService.getInstance().getEmployeeList()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employee/{empId}")
	public Response getEmployee(@PathParam("empId") @DefaultValue("0") Long empId) {
		return Response.status(Response.Status.OK).entity(EmployeeService.getInstance().getEmployeeDetail(empId))
				.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employee/")
	public Response createEmployee(Employee employee) {
		
		ObjectNode json = mapper.createObjectNode();
		json.put("InsertStatus", EmployeeService.getInstance().createEmployee(employee));
		return Response.status(Response.Status.OK).entity(json)
				.build();
	}
}
