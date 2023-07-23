package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
public class AppContextAttributeListener implements ServletContextAttributeListener {

	public AppContextAttributeListener() {
    }

	public void attributeAdded(ServletContextAttributeEvent scae)  { 
		System.out.println("Servlet Context Added");
		System.out.println(scae.getName() +" - "+ scae.getValue() );
	}

	public void attributeRemoved(ServletContextAttributeEvent scae)  { 
		System.out.println("Servlet Context Removed");
		System.out.println(scae.getName()+"-"+scae.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scae)  { 
		System.out.println("Servlet Context Replaced");
		System.out.println(scae.getName()+"-"+scae.getValue());
	}
	
}
