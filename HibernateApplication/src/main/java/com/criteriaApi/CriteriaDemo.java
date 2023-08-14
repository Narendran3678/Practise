package com.criteriaApi;

import java.util.List;

import com.mapping.onetomany.Director;
import com.mapping.onetomany.Director_;
import com.mapping.onetomany.Movie;
import com.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public class CriteriaDemo {
	static EntityManager entityMgr = JPAUtil.getJPASessionFactory().createEntityManager();
	public static void main(String args[])
	{
		//criteriaMethodFullSelect();
		//criteriaMethodSelectiveColumns();
		criteriaMethodJoin();
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
	public static void criteriaMethodSelectiveColumns()
	{
		try
		{
			Long directorSearchId = 1L;
			CriteriaBuilder builder = entityMgr.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
			
			Root<Director> root = criteriaQuery.from(Director.class);
			/*
			Path<String> directorName = root.get("directorName");
			Path<Integer> movieCount = root.get("numberOfMovies");
			Path<List<Movie>> movieList = root.get("movieList");
			*/
			
			// To Access Director_  Set this path "/target/generated-sources/annotations" in Properties -> Java Compiler -> Annoation Processing . And Set the path in the "Generated source directory" and for test too
			Path<Long> directorId = root.get(Director_.id); 
			Path<String> directorName = root.get(Director_.directorName); 
			Path<Integer> movieCount = root.get(Director_.numberOfMovies);
			Expression<List<Movie>> movieList = root.get(Director_.movieList);
			
			//criteriaQuery.where(builder.equal(directorId, directorSearchId)); // Where Condition  
			
			criteriaQuery.where(builder.equal(directorId, builder.parameter(Director.class,Director_.ID)));
			criteriaQuery.multiselect(directorName,movieCount,movieList);
			
			TypedQuery<Object[]> query = entityMgr.createQuery(criteriaQuery).setParameter("id", directorSearchId); 
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
	public static void criteriaMethodJoin()
	{
		CriteriaBuilder builder = entityMgr.getCriteriaBuilder();
		CriteriaQuery<Director> criteriaQuery = builder.createQuery(Director.class);
		Root<Director> root = criteriaQuery.from(Director.class);
		Join<Director,Movie> dmjoin = root.join(Director_.movieList,JoinType.LEFT);
		criteriaQuery.select(root);
		
		TypedQuery<Director> query = entityMgr.createQuery(criteriaQuery); 
		List<Director> directorList = query.getResultList();
		directorList.forEach(System.out::println);
	}
}
