package com.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.DAOI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAOUtil {
	//Hibernate
	static Session session = null;
	static Transaction transaction = null;

	//JPA
	static EntityManager entityManager = null;
	static EntityTransaction entityTransaction = null;
	
	public void hibernatePersistDAO(DAOI daoI)
	{
		try {
			if(session==null || !session.isOpen())
			{
				System.out.println("Session not open");
				session = HibernateUtil.getInstance().getSessionFactory().openSession();
				System.out.println("Session Opened");
			}
			if(transaction==null || !transaction.isActive())
			{
				System.out.println("Transaction not begin");
				transaction = session.beginTransaction();
				System.out.println("Transaction Begin");
			}	
			session.persist(daoI);
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return;
		} 
	}
	public void hibernateCommitTransaction()
	{
		if(transaction!=null)
		{
			transaction.commit();
			System.out.println("Transaction Commited");
		}
	}
	public void hibernateCloseSession()
	{
		if (session != null) {
			session.close();
			System.out.println("Session Closed");
		}
	}
	
	
	public void jpaPersistDAO(DAOI daoI)
	{
		try
		{
			if(entityManager==null && !entityManager.isOpen())
			{
				System.out.println("Session not open");
				entityManager = JPAUtil.getJPASessionFactory().createEntityManager();
				System.out.println("Session Opened");
			}
			if(entityTransaction==null || !entityTransaction.isActive())
			{
				System.out.println("Transaction not begin");
				entityTransaction = entityManager.getTransaction();
				System.out.println("Transaction Begin");
			}
			
			entityManager.persist(daoI);
		} catch (Exception e) {
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
			return;
		} 
	}
	public void jpaCommitTransaction()
	{
		if(entityTransaction!=null)
		{
			entityTransaction.commit();
			System.out.println("Transaction Commited");
		}
	}
	public void jpsCloseSession()
	{
		if (entityManager != null) {
			entityManager.close();
			System.out.println("Session Closed");
		}
	}
}
