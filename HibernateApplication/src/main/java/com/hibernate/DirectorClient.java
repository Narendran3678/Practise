package com.hibernate;

import java.util.*;
import org.hibernate.*;
import com.mapping.onetomany.*;
import com.util.HibernateUtil;
public class DirectorClient {
	public static void main(String args[])
	{
		//persistDirector();
		getDirectorDetail(1L);
		//persistMovie();
		//addMovie(1L);
	}
	public static void persistDirector()
	{
		List<Movie> movieList =  new ArrayList<>();
		Director director = new Director("Christoper Nolan",2);
		Movie movie = new Movie("Tenet");
		Movie movie1 = new Movie("Galaxy");
		movie.setDirector(director);
		movie1.setDirector(director);
		movieList.add(movie);
		movieList.add(movie1);
		director.setMovieList(movieList);
		DirectorDao.persistDirector(director);
	}
	public static void persistMovie()
	{	
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getInstance().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Director director = new Director("James Camerron",10);
			Movie movie = new Movie("Titanic");
			Movie movie1 = new Movie("Avatar");
			movie.setDirector(director);
			movie1.setDirector(director);
			session.persist(movie);
			session.persist(movie1);
			
			transaction.commit();
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
	public static void getDirectorDetail(Long id)
	{
		//System.out.println(DirectorDao.getDirector(id));
		DirectorDao.getJpaDirectors();
		//DirectorDao.getJpaDirector(1L);
	}
	public static void addMovie(Long id)
	{
		Director director = DirectorDao.getDirector(id);
		Movie movie = new Movie("Avatar Way of Water");
		movie.setDirector(director);
		director.getMovieList().add(movie);
		DirectorDao.mergeDirector(director);
	}
}
