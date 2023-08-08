package com.util;
import com.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
 
public class JPAUtil { 
	static EntityManagerFactory factory = null;	
	public static EntityManagerFactory getJPASessionFactory()
	{
		if(factory==null || !factory.isOpen())
			factory = Persistence.createEntityManagerFactory("persistence-xml");
		return factory;
	}
	public static void main(String args[])
	{
		
	}
	public static void persistData()
	{
		EntityManager entityMgr = getJPASessionFactory().createEntityManager();
		EntityTransaction transaction = entityMgr.getTransaction();
		try
		{
			transaction.begin();
			Student student = new Student("John", "Wick", "johnwick@javaguides.com");
			entityMgr.persist(student);
			transaction.commit();
		}
		catch(Exception e)
		{
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			if(entityMgr!=null)
			{
				entityMgr.close();
			}
			if(factory!=null)
			{
				factory.close();	
			}
		}
	}
	public static void getDatas()
	{
		EntityManager entityMgr = getJPASessionFactory().createEntityManager();
		EntityTransaction transaction = entityMgr.getTransaction();
	}
}
