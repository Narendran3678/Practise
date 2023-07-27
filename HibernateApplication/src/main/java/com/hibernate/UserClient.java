package com.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Address;
import com.entity.Name;
import com.entity.Salutation;
import com.entity.User;
import com.util.HibernateUtil;

public class UserClient 
{
	public static void main(String args[])
	{
		Session session =null;
		Transaction transaction = null;
	
		Name name = new Name(Salutation.MR,"Narendran","Naren");
		Address address = new Address("29","Nattar Street","Murungapakkam","Puducherry","India","605004");
		User user = new User("narendran3678@gmail.com","7092802533",address,name);
		
		try
		{
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction= session.beginTransaction();
			session.persist(user);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			if(session!= null)
				session.close();
		}
	}
}	
