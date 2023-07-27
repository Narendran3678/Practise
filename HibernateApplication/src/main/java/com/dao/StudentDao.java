package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(student); // or session.merge(student);
			transaction.commit();
			System.out.println(student);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void mergeStudent(Student student) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.merge(student); // Persist Operation Not Allowed for update
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() {
		SessionFactory sessionFactory = null;
		Session session = null;
		List<Student> studentList = null;
		try {
			sessionFactory = HibernateUtil.getInstance().getSessionFactoryJava();
			session = sessionFactory.openSession();
			studentList = session.createQuery("from Student", Student.class).list(); // from Student ->'Student'
																						// Casesensitive ClassName
			studentList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return studentList;
	}

	public Student getStudent(Long id) // Return Null if data not found
	{
		Student student = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getInstance().getSessionFactoryJava();
			session = sessionFactory.openSession();
			student = session.get(Student.class, id);
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return student;
	}
	
	public Student getStudentByReference(Long id) // throw Object not found exception if data not found
	{
		Student student = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getInstance().getSessionFactoryJava();
			session = sessionFactory.openSession();

			student = session.byId(Student.class).getReference(id);
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return student;
	}
	public void deleteStudent(Long id)
	{
		Student student = new Student();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getInstance().getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			System.out.println(student);
			session.remove(student);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null)
			{
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
