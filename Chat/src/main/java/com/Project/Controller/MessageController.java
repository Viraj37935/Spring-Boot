package com.Project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.MessageReqDTO;
import com.Project.DTO.MessageResDTO;
import com.Project.Service.MessageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chat")
public class MessageController {

	private MessageService service;
	
	public MessageController(MessageService service) {
		this.service=service;
	}
	
	@PostMapping("/send")
	public MessageResDTO send(@RequestBody MessageReqDTO dto) {
		return service.sendMesaage(dto);
	}
	
	
	@GetMapping("/all-chat/{sender}/{receiver}")
	public List<MessageResDTO> allChat(@PathVariable Long sender,
			@PathVariable  Long receiver){
		
		return service.getChat(sender, receiver);
	}
}
