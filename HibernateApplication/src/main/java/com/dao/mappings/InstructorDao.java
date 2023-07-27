package com.dao.mappings;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.Instructor;
import com.util.HibernateUtil;

public class InstructorDao {
	public static void persistInstructor(Instructor instructor) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(instructor);
			transaction.commit();
			System.out.println(instructor);
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
}
