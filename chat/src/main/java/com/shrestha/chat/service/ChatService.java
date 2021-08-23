package com.shrestha.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrestha.chat.dal.Chat;
import com.shrestha.chat.dal.repository.ChatRepository;
import com.shrestha.chat.exception.AlreadyFoundException;

@Service
public class ChatService {
	
	private final ChatRepository chatRepository;
	private final UserService userService;
	
	@Autowired
	public ChatService(ChatRepository chatRepository, UserService userService) {
		this.chatRepository = chatRepository;
		this.userService = userService;
	}
	
	public void save(final Chat chat) throws AlreadyFoundException {
		
		if(!userService.checkUser(chat.getChatFrom())) {
			chatRepository.save(chat);
		}
		
	}

}
