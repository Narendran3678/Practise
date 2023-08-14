package com.mapping.onetomany;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.DAOI;
import com.util.HibernateUtil;
import com.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@SuppressWarnings("unchecked")
public class DirectorDao {
	static Session session = null;
	public static void persistDirector(DAOI daoI)
	{
		Transaction transaction = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(daoI);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
	}
	public static Director getDirector(Long directorId)
	{
		Transaction transaction = null;
		Director director = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			director = session.get(Director.class,directorId);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
		return director;
	}
	
	public static List<Object[]> getJpaDirector(Long id)
	{
		List<Object[]> objectList = null;
		EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
		try
		{
			objectList = entityMgr.createNamedQuery("diretor_movie_join").setParameter("id", id).getResultList();
			for(Object[] objArr:objectList)
			{
				for(Object obj:objArr)
				{
					System.out.print(obj+"-");
				}
				System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(entityMgr!=null)
			{
				entityMgr.close();
			}
		}
		return objectList;
	}
	public static List<Object[]> getJpaDirectors()
	{
		List<Object[]> listObj  = null;
		EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
		try
		{
			/*
			Query query = entityMgr.createQuery("select dir from Director dir inner join dir.movieList");
			directorList = query.getResultList();
			directorList.forEach(System.out::println);
			*/
			
			/*
			Query query = entityMgr.createNativeQuery("select dir.director_name,dir.movie_count,mov.movie_name from director dir left outer join movie mov on dir.id = mov.director_id");
			listObj = query.getResultList();
			for(Object[] objArr:listObj)
			{
				for(Object obj:objArr)
				{
					System.out.print(obj+"-");
				}
				System.out.println();
			}
			*/
			
			List<Director> directorList = entityMgr.createQuery("from Director").getResultList();
			for(Director director : directorList)
			{
				System.out.println(director.toString());
				director.getMovieList().forEach(System.out::println);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(entityMgr!=null)
			{
				entityMgr.close();
			}
		}
		return listObj;
	}
	public static void mergeDirector(DAOI daoI)
	{
		Transaction transaction = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.merge(daoI);
			transaction.commit();
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
		}
	}
}
