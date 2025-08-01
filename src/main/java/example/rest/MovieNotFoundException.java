package example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Unchecked
@ResponseStatus(HttpStatus.NOT_FOUND) //Use to specify the response header 'status'
public class MovieNotFoundException extends RuntimeException {
	public MovieNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
