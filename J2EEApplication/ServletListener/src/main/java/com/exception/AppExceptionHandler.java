package com.exception;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AppExceptionHandler() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request,response);
	}
	private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode  = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName  = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestUri   = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		if(servletName == null)
		{
			servletName = "Unknown";
		}
		if(requestUri == null)
		{
			requestUri = "http://localhost:8080/ServletFilter";
		}
		
		if(statusCode == 500){
			response.getWriter().append("Exception / Error Detail").append("\n")
			.append("Status : "+statusCode).append("\n")
			.append("ServletName : "+servletName).append("\n")
			.append("Request URI : "+requestUri).append("\n")
			.append("Exception Type : "+throwable.getClass().getName()).append("\n")
			.append("Message : "+throwable.getMessage());
		}
		else
		{
			response.getWriter().append("Exception / Error Detail").append("\n")
			.append("Status : "+statusCode).append("\n")
			.append("ServletName : "+servletName).append("\n")
			.append("Request URI : "+requestUri);
		}
	}

}
