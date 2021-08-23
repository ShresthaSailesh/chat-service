package com.shrestha.chat.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class ChatDTO {
	
	private String from;
	private String message;
	private String time;

}
