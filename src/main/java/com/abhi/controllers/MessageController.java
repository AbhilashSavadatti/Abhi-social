package com.abhi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Message;

@RestController
public class MessageController {

	
	@GetMapping("/message")
	public List<Message> getMessage(){
		
		List<Message> messages = new ArrayList<>();
		
		
		Message message1= new Message("Salaar has crossed 500M");
		Message message2 = new Message("Bahubali 3 will be released on 2027");
		
		messages.add(message1);
		messages.add(message2);
		
		return messages;
	}
	
}
