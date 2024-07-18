package com.abhi.service;

import java.util.List;

import com.abhi.models.Message;
import com.abhi.models.User;

public interface MesssageService {

	
	
		public Message createMessage(User user, Integer chatId, Message req) throws Exception;
		
		public List<Message> findChatsMessages(Integer chatId) throws Exception;
		
}
