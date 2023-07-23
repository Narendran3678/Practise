package com.servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ListenerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		StringBuilder sb = new StringBuilder();
		ServletContext context = request.getServletContext();
		context.setAttribute("Attribute_Key", "Attribute_Value");
		Enumeration<String> enumContext = context.getInitParameterNames();
    	while(enumContext.hasMoreElements())
    	{
    		String key=enumContext.nextElement();
    		sb.append(key +" -> Value -> "+context.getInitParameter(key)).append("\n");
    	}
    	context.setAttribute("Attribute_Key", "Attribute_Value1");
    	context.removeAttribute("Attribute_Key");
    	
    	session.setAttribute("UserName", "Naren");
    	session.setAttribute("UserName", "John");
    	session.removeAttribute("UserName");
    	
		response.getWriter().append(sb);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
