package com.inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InheritanceDemo {
	//static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-xml");	
	public static void main(String args[])
	{
		persistData();
	}
	public static void persistData()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-xml");
		EntityManager entityMgr = factory.createEntityManager();
		EntityTransaction transaction = entityMgr.getTransaction();
		try
		{
			transaction.begin();
			DebitCard account = new DebitCard();
			account.setAccoutNumber("2132551");
			account.setAccountOwner("Narendran");
			account.setAccountBalance("150000");
			account.setCardType("Platinum");
			account.setWifiEnabled(false);
			entityMgr.persist(account);
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
}
