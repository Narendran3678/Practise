package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;
import com.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class StudentDao {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
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
		finally
		{
			if(session!=null)
			{
				session.close();
			}
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
	
	public void saveJPAStudent(Student student) {
		EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
		EntityTransaction transaction = entityMgr.getTransaction();
		try
		{
			transaction.begin();
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
			
		}
	}
	public List<Student> getJPAStudents() {
		EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
		List<Student> studentList = null;
		try {
			
			//studentList = entityMgr.createQuery("select stud from Student stud", Student.class).getResultList(); // from Student ->'Student'  Case Sensitive ClassName
			Query query = entityMgr.createNativeQuery("select * from Student", Student.class);
			studentList = query.getResultList();
			
			studentList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityMgr != null) {
				entityMgr.close();
			}
		}
		return studentList;
	}
	public Student getJPAStudent(Long id) {
		EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
		Student student = null;
		try {
			Query query = entityMgr.createQuery("select student from Student student where student.id = :id",Student.class);
			query.setParameter("id", id);
			
			student =(Student) query.getSingleResult();
			
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityMgr != null) {
				entityMgr.close();
			}
		}
		return student;
	}
}
