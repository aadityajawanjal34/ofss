package example.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
	// This class is meant for holding several movie objects
	private static Map<Integer, Movie> allMovies;
	
	static {
		allMovies = new HashMap<>();
		Movie m1 = new Movie(101, "Life Of Pi", "Emotional", 125);
		Movie m2 = new Movie(102, "Speed", "Action", 85);
		Movie m3 = new Movie(103, "Predator", "Horror", 95);
		Movie m4 = new Movie(104, "Inception", "Sci-Fi", 148);
		Movie m5 = new Movie(105, "The Godfather", "Crime", 175);
		Movie m6 = new Movie(106, "Finding Nemo", "Animation", 100);
		Movie m7 = new Movie(107, "Mad Max: Fury Road", "Action", 120);
		Movie m8 = new Movie(108, "John Wick", "Action", 101);
		
		allMovies.put(m1.getMovieId(), m1);
		allMovies.put(m2.getMovieId(), m2);
		allMovies.put(m3.getMovieId(), m3);
		allMovies.put(m4.getMovieId(), m4);
		allMovies.put(m5.getMovieId(), m5);
		allMovies.put(m6.getMovieId(), m6);
		allMovies.put(m7.getMovieId(), m7);
		allMovies.put(m8.getMovieId(), m8);
	}
	
	public static Collection<Movie> getAllMovies(){
		// returns all the movies
		return allMovies.values();
	}
	
	public static Movie getMovieById(Integer id) {
		Movie m = allMovies.get(id);
		return m;
	}
	
	public static void createNewMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	
	public static void updateMovie(Movie movieObject) {
		allMovies.put(movieObject.getMovieId(), movieObject);
	}
	
	public static void deleteMovie(Integer movieId) {
		allMovies.remove(movieId);
	}
}
