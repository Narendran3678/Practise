package com.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter{


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("Filter Initilalized-"+filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String credEncrypted = req.getServletContext().getInitParameter("Base64DecodedValue");
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(credEncrypted+"-"+user+"-"+password+"-"+credEncrypted);
		String authCode = req.getParameter("authCode");
		if(authCode==null && user ==null && password==null)
		{
			chain.doFilter(req, resp); 	
		}
		else
		{
			
			String authValue = Base64.getEncoder().encodeToString((user+":"+password).getBytes());		
			if(!authValue.equals(credEncrypted))
			{
				req.setAttribute("authCode", authValue);
				resp.getWriter().append("Login Failed");
			}
			else
			{
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("Filter Destroyed");
		Filter.super.destroy();
	}

}
