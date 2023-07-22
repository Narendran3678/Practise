package com.j2ee.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String USERNAME="Naren";
	private static String PASSWORD="Naren";
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(userName.trim().equals(USERNAME) && password.trim().equals(PASSWORD))
		{
			HttpSession session = request.getSession();
			session.setAttribute("Sessionkey", userName.trim()+":"+password.trim());
			Cookie cookie = new Cookie("CookieKey",userName.trim()+":"+password.trim());
			cookie.setMaxAge(100);
			response.addCookie(cookie);

			dispatcher =  request.getRequestDispatcher("jsp/LoginSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher =  request.getRequestDispatcher("jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
		//response.getWriter().append("LoginServlet").append(request.getContextPath());
	}
}
