package com.criteriaApi;

import java.util.List;

import com.mapping.onetomany.Director;
import com.mapping.onetomany.Movie;
import com.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public class CriteriaDemo {
	static EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
	public static void main(String args[])
	{
		//criteriaMethodFullSelect();
		criteriaMethodSelective();
	}
	public static void criteriaMethodFullSelect()
	{
		try
		{
			CriteriaBuilder builder = entityMgr.getCriteriaBuilder();
			CriteriaQuery<Director> criteriaQuery = builder.createQuery(Director.class);
			Root<Director> root = criteriaQuery.from(Director.class);
			criteriaQuery.select(root);
			
			TypedQuery<Director> query = entityMgr.createQuery(criteriaQuery); 
			List<Director> directorList = query.getResultList();
			directorList.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(entityMgr!=null)
				entityMgr.close();			
		}
	}
	public static void criteriaMethodSelective()
	{
		try
		{
			CriteriaBuilder builder = entityMgr.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
			
			Root<Director> root = criteriaQuery.from(Director.class);
			/*
			Path<String> directorName = root.get("directorName");
			Path<Integer> movieCount = root.get("numberOfMovies");
			Path<List<Movie>> movieList = root.get("movieList");
			*/
			Path<String> directorName = root.get("");
			Path<Integer> movieCount = root.get("numberOfMovies");
			Path<List<Movie>> movieList = root.get("movieList");
			criteriaQuery.multiselect(directorName,movieCount,movieList);
			
			TypedQuery<Object[]> query = entityMgr.createQuery(criteriaQuery); 
			List<Object[]> directorList = query.getResultList();
			
			for(Object[] object: directorList)
			{
				for(Object obj: object)
					System.out.print(obj+"-");
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
				entityMgr.close();			
		}
	}
}
