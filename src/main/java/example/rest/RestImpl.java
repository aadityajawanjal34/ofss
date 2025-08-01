package example.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as an implementation class
public class RestImpl {
	// This class is meant for exposing REST Endpoints
	//End Point: do-greet => Welcome To REST
	
	@RequestMapping("/do-greet") // Marks this method as request handling method.
	public String doGreet() {
		return "Welcome to My First REST Demo";
	}
	
	@RequestMapping ("/get-message")
	public Message getMessage() {
		return new Message();
	}
	
	@RequestMapping ("/get-all-msgs")
	public List<Message> getAllMessages(){
		Message msg = new Message();
		Message msg2 = new Message("Bye Bye 2024",LocalDate.of(2024, 12, 31));
		Message msg3 = new Message("Happy Independence Day", LocalDate.of(2024, 8, 15));
		List<Message> listOfMessages = List.of(msg,msg2,msg3);
		return listOfMessages;
	}
}

// End Point: /get-message Response: Message Object (Content, deliveredOn)