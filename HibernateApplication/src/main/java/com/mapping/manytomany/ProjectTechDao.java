package com.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.DAOI;
import com.util.HibernateUtil;

public class ProjectTechDao {
	
	static Session session = null;
	static Transaction transaction = null;
	public static void persistDirector(DAOI daoI)
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
				System.out.println("Session Begin");
			}	
			session.persist(daoI);
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}
	public static void closeSession()
	{
		if (session != null) {
			session.close();
			System.out.println("Session Closed");
		}
	}
	public static void commitTransaction()
	{
		transaction.commit();
		System.out.println("Transaction Commited");
	}
}
