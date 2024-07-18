package com.abhi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Message;
import com.abhi.models.User;
import com.abhi.service.MesssageService;
import com.abhi.service.UserService;

@RestController
public class CreateMessage {

		@Autowired
		private MesssageService messsageService;
		
		@Autowired
		private UserService userService;
		
		
		@PostMapping("/api/messages/chat/{chatId}")
		public Message createMessage(@RequestBody Message req , @RequestHeader("Authorization") String jwt ,@PathVariable Integer chatId ) throws Exception {
			
			User user = userService.findUserByJwt(jwt);
			
			Message message = messsageService.createMessage(user, chatId, req);
			
		
			return message;
			
			
		}
		
		@GetMapping("/api/messages/chat/{chatId}")
		public List<Message> createMessage(@PathVariable Integer chatId ) throws Exception {
			
			
			
			List<Message> message = messsageService.findChatsMessages(chatId);
			
		
			return message;
			
			
		}
		
		
	
}
