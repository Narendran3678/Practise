package com.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.DAOI;
import com.util.HibernateUtil;

public class InstructorDao  {
	public static void persistInstructor(DAOI daoI) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(daoI);
			transaction.commit();
			System.out.println(daoI);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public static Instructor getInstructor(Long instructorId) 
	{	
		Instructor instructor = null;
		Session session = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			instructor= session.get(Instructor.class,instructorId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return instructor;
	}
}
