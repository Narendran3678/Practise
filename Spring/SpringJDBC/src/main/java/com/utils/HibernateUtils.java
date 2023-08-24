package com.utils;

import org.hibernate.SessionFactory;

public class HibernateUtils {
	private SessionFactory sessionFactory ;
	private HibernateUtils(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getHibernateSession()
	{
		try {
			if(sessionFactory==null)
				throw new Exception("Hibernate Session Factory Not Initialized");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
