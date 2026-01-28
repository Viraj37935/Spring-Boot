package com.example.chat.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.Entity.Message;

@RestController
@RequestMapping("/chat")
public class Chat_Controller {

	List<Message> messages = new ArrayList<>();

	// SEND MESSAGE
	@PostMapping("/send")
	public Message sendMessage(@RequestBody Message message) {
		messages.add(message);
		return message;
	}

	// GET ALL MESSAGES
	@GetMapping("/messages")
	public List<Message> getAllMessages() {
		return messages;
	}
}