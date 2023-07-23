package com.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

    public AppContextListener() {

    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("AppContextListener Destroyed");
    }
    public void contextInitialized(ServletContextEvent sce)  {
    	
    	ServletContext context = sce.getServletContext();
    	context.setInitParameter("New_Param","New_Value");
    	Enumeration<String> enumContext = context.getInitParameterNames();
    	while(enumContext.hasMoreElements())
    	{
    		String key=enumContext.nextElement();
    		System.out.println(key +" -> Value "+context.getInitParameter(key));
    	}
    	System.out.println("Context Initialized Printed value are above");
    }	
}
