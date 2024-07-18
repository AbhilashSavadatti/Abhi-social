package com.abhi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.models.Chat;
import com.abhi.models.Message;
import com.abhi.models.User;
import com.abhi.repository.MessageRepository;


@Service
public class MessageServiceImplementation implements MesssageService{

		@Autowired
		private MessageRepository messageRepository;
		
		@Autowired
		private ChatService  chatService;
		
		
	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws Exception {
		
		
		Message message = new Message();
		
		Chat chat = chatService.findChatById(chatId);
		
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		message.setTimestamp(LocalDateTime.now());
		
		
		return messageRepository.save(message);
	}

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws Exception {
		Chat chat = chatService.findChatById(chatId);
		
		
		
		return messageRepository.findByChatId(chatId);
	}

}
