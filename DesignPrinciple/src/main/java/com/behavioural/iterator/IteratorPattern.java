package com.behavioural.iterator;

import java.util.*;

class Movie
{
	String movieName;
	String releasedYear;
	String directorName;
	public Movie() {}
	public Movie(String movieName, String releasedYear, String directorName) {
		super();
		this.movieName = movieName;
		this.releasedYear = releasedYear;
		this.directorName = directorName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", releasedYear=" + releasedYear + ", directorName=" + directorName
				+ "]";
	}	
}
interface MovieI
{
	public void collectMovie();
	public Object getMovie();	
}
interface MovieIterator
{
	public Iterator<Movie> iterate();
}
class ThrillerMovie implements MovieI,MovieIterator
{
	private List<Movie> thrillerMovie ;

	@Override
	public void collectMovie() {
		if(thrillerMovie==null || thrillerMovie.size()==0)
		{
			thrillerMovie = new ArrayList<>();
			thrillerMovie.add(new Movie("Mission Impossible","2021","James"));
			thrillerMovie.add(new Movie("Saw","2018","Mike"));
			
			
		}
	}

	@Override
	public List<Movie> getMovie() {
		return thrillerMovie;
	}

	@Override
	public Iterator<Movie> iterate() {
		return thrillerMovie.iterator();
	}
	
}
class RomanticMovie implements MovieI,MovieIterator
{
	private static int movieSize=0;
	private Movie[] romanticMovie ;
	
	@Override
	public void collectMovie() {
		if(romanticMovie==null || romanticMovie.length==0)
		{
			romanticMovie = new Movie[2];
			romanticMovie[movieSize++] = new Movie("Titanic","1996","Cole");
			romanticMovie[movieSize++] = new Movie("Rain","2021","Kane");
		}
	}

	@Override
	public Movie[] getMovie() {
		return romanticMovie;
	}

	@Override
	public Iterator<Movie> iterate() {
		return Arrays.asList(romanticMovie).iterator();
	}
}
class HorrorMovie implements MovieI,MovieIterator
{
	private Map<Integer,Movie> horrorMovie = new HashMap<>();
	private static int movieIndex=0;
	@Override
	public void collectMovie() {
		if(horrorMovie==null || horrorMovie.size()==0)
		{
			horrorMovie.put(movieIndex++, new Movie("Chainsaw Massacre","2016","Andy"));
			horrorMovie.put(movieIndex++, new Movie("Annabelle","2005","Jeff"));
		}
	}
	@Override
	public Map<Integer,Movie> getMovie() {
		return horrorMovie;
	}
	@Override
	public Iterator<Movie> iterate() {
		return horrorMovie.values().iterator();
	}
	
}
public class IteratorPattern {
	public static void main(String args[]) {
		MovieI horrorMovie = new HorrorMovie();
		MovieI romanticMovie = new RomanticMovie();
		MovieI thrillerMovie = new ThrillerMovie();
		horrorMovie.collectMovie();
		romanticMovie.collectMovie();
		thrillerMovie.collectMovie();
		
		System.out.println("Horror Movie");
		iterate(((HorrorMovie)horrorMovie).iterate());
		System.out.println();
		System.out.println("Romantic Movie");
		iterate(((RomanticMovie)romanticMovie).iterate());
		System.out.println();
		System.out.println("Thriller Movie");
		iterate(((ThrillerMovie)thrillerMovie).iterate());
		System.out.println();
	}
	public static void iterate(Iterator<Movie> movieIterator)
	{
		
		while(movieIterator.hasNext())
		{
			System.out.println(movieIterator.next());
		}
	}
}
