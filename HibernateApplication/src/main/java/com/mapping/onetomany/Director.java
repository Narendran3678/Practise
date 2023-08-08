package com.mapping.onetomany;

import java.util.List;
import com.entity.DAOI;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="director")
public class Director extends DAOI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="director_name")
	private String directorName;

	@Column(name="movie_count")
	private int numberOfMovies;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="director",fetch = FetchType.EAGER)
	private List<Movie> movieList;
	
	public Director()
	{
		
	}
	
	public Director(String directorName, int numberOfMovies) {
		super();
		this.directorName = directorName;
		this.numberOfMovies = numberOfMovies;
	}

	public Director(String directorName, int numberOfMovies, List<Movie> movieList) {
		super();
		this.directorName = directorName;
		this.numberOfMovies = numberOfMovies;
		this.movieList = movieList;
	}

	public long getId() {
		return id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public int getNumberOfMovies() {
		return numberOfMovies;
	}

	public void setNumberOfMovies(int numberOfMovies) {
		this.numberOfMovies = numberOfMovies;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", directorName=" + directorName + ", numberOfMovies=" + numberOfMovies
				+ ", movieList=" + movieList + "]";
	}

	
}
