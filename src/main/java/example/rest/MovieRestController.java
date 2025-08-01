package example.rest;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins=("*"))
public class MovieRestController {
//	@RequestMapping ("/movie-api") // by default the request is GET
	@GetMapping ("/movie-api")
	public Collection<Movie> getAllMovies(){
		return MovieRepository.getAllMovies();
	}
	 
	@GetMapping ("/movie-api/{movie_id}")
	public Movie getMovie(@PathVariable("movie_id") Integer movieId) {
		Movie m = MovieRepository.getMovieById(movieId);
		
		if(m == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		
		return m;
	}
	
	@GetMapping ("/movie-api/having-genre/{genre}")
	public Collection<Movie> getAllMoviesHavingGenre(@PathVariable String genre){
			Collection<Movie> movieCollection = MovieRepository.getAllMovies();
			Stream<Movie> filteredStream = movieCollection.stream()
			.filter(currentMovie -> currentMovie.getGenre().equals(genre));	
			
			return filteredStream.collect(Collectors.toList());
	}
	
//	@RequestMapping (value = "/movie-api", method = RequestMethod.POST) // POST
	@PostMapping ("/movie-api")
	public void addNewMovie(@RequestBody Movie movieObject) { 
		// @ResuestBody fetch the data from body of HTTP request and store it in java object
		System.out.println("Received movie: " + movieObject);
		MovieRepository.createNewMovie(movieObject);
	}
	
	@PutMapping ("/movie-api")
	public void updateMovie(@RequestBody Movie movieObject) { 
		// @ResuestBody fetch the data from body of HTTP request and store it in java object
		System.out.println("Received movie: " + movieObject);
		MovieRepository.updateMovie(movieObject);
	}
	
	@DeleteMapping ("/movie-api/{movieId}")
	public void deleteMovie(@PathVariable Integer movieId) {
		MovieRepository.deleteMovie(movieId);
	}
	
	@PostMapping ("/movie-info")
	public void acceptMpvieInfo(@RequestBody MovieInfo movieInfoRef) {
		System.out.println(movieInfoRef);
		// Depending upon the requirement, further processing may take place
	}
}
