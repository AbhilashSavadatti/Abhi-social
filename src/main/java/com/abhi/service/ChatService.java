package com.abhi.service;

import java.util.List;


import com.abhi.models.Chat;
import com.abhi.models.User;


public interface ChatService {

	
		public Chat createChat(User reqUser, User user2);
		
		public Chat findChatById(Integer chatId) throws Exception;
		
		
		public List<Chat> findUsersChat(Integer userId);
}
