package com.j2ee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletInfo());
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Login.jsp");
		
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("Sessionkey")!=null)
		{
			System.out.println(session.getAttribute("Sessionkey"));
			session.invalidate();
		}
		else
		{
			response.getWriter().append("Session Cleared");
			return;
		}
		for(Cookie cookie: request.getCookies())
		{
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
