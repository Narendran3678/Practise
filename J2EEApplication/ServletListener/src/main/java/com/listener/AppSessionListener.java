package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public AppSessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session Destroyed");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Added");
    	System.out.println(se.getName()+"-"+se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Removed");
    	System.out.println(se.getName()+"-"+se.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Replaced");
    	System.out.println(se.getName()+"-"+se.getValue());
    }
	
}
