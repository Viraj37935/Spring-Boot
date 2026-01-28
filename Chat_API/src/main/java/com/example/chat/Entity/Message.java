package com.example.chat.Entity;

import org.springframework.stereotype.Component;

@Component 
public class Message {

	String sender;
	String text;

	public Message() {
	}

	public Message(String sender, String text) {
		this.sender = sender;
		this.text = text;
	}

	public String getSend() {
		return sender;
	}

	public String getText() {
		return text;
	}

}
