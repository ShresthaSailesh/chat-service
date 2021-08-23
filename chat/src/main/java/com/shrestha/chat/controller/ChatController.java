package com.shrestha.chat.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrestha.chat.dal.Chat;
import com.shrestha.chat.dto.ChatDTO;
import com.shrestha.chat.exception.AlreadyFoundException;
import com.shrestha.chat.service.ChatService;
import com.shrestha.chat.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/rest/v1/chat")
public class ChatController {

	private final ChatService chatService;
	private final UserService userService;
	private final SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public ChatController(ChatService chatService, SimpMessagingTemplate simpMessagingTemplate,UserService userService) {
		this.chatService = chatService;
		this.simpMessagingTemplate = simpMessagingTemplate;
		this.userService = userService;
	}

	@MessageMapping("/{sendTo}")
	@PostMapping("/{sendTo}")
	public void sendMessage(@PathVariable(value = "sendTo") String sendTo, @RequestBody ChatDTO chatDTO) throws AlreadyFoundException, NotFoundException{
		Chat chat = new Chat();
		if(!userService.checkUser(sendTo)) {
			throw new NotFoundException(sendTo +" user not found Exception!!!");
		}
		chat.setChatFrom(chatDTO.getFrom());
		chat.setTimeStamp(Instant.now().toString());
		chat.setMessage(chatDTO.getMessage());
		chatService.save(chat);
		simpMessagingTemplate.convertAndSend("/topic/chats/"+ sendTo, chatDTO);

	}

}
