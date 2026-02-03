package com.Project.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Project.DTO.MessageReqDTO;
import com.Project.DTO.MessageResDTO;
import com.Project.Entity.MessageEntity;
import com.Project.Repository.MessageRepository;

@Service
public class MessageService {
	private MessageRepository repo;
	
	public MessageService(MessageRepository repo) {
		this.repo=repo;
	}
	
    public MessageResDTO sendMessage(MessageReqDTO dto) {

        MessageEntity msg = new  MessageEntity();
        msg.setSenderId(dto.getSenderId());
        msg.setReceiverId(dto.getReceiverId());
        msg.setContent(dto.getContent());
        msg.setTimestamp(LocalDateTime.now());

        MessageEntity saved = repo.save(msg);

       return new MessageResDTO(
    		   saved.getId(),
    		   saved.getContent(),
    		   saved.getTimestamp());
    		   
   }
    
    public List<MessageResDTO> getChat(Long sender, Long receiver) {

        return repo.findBySenderIdAndReceiverId(sender, receiver)
                .stream()
                .map(m -> new MessageResDTO(
                        m.getId(),
                        m.getContent(),
                        m.getTimestamp()))
                .collect(Collectors.toList());
    }

}
