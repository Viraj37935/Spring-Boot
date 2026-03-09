package com.Project.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Project.DTO.MessageReqDTO;
import com.Project.DTO.MessageResDTO;
import com.Project.Entity.MessageEntity;
import com.Project.Entity.UserEntity;
import com.Project.Repository.MessageRepository;
import com.Project.Repository.UserRepository;

@Service
public class MessageService {

    private MessageRepository messageRepo;
    private UserRepository userRepo;

    public MessageService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    public MessageResDTO sendMesaage(MessageReqDTO dto) {

        UserEntity sender = userRepo.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not Found"));

        UserEntity receiver = userRepo.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        MessageEntity msg = new MessageEntity();
        msg.setSender(sender);
        msg.setReceiver(receiver);
        msg.setContent(dto.getContent());
        msg.setTimestamp(LocalDateTime.now());

        MessageEntity saved = messageRepo.save(msg);

        return new MessageResDTO(
        	    saved.getId(),
        	    saved.getSender().getId(),
        	    saved.getSender().getName(),
        	    saved.getReceiver().getId(),
        	    saved.getReceiver().getName(),
        	    saved.getContent(),
        	    saved.getTimestamp()
        	);
    }

    public List<MessageResDTO> getChat(Long senderId, Long receiverId) {

        UserEntity user1 = userRepo.findById(senderId)
                .orElseThrow(() -> new RuntimeException("User1 not found"));

        UserEntity user2 = userRepo.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("User2 not found"));

        return messageRepo.findConversation(user1, user2)
                .stream()
                .map(m -> new MessageResDTO(
                	    m.getId(),
                	    m.getSender().getId(),
                	    m.getSender().getName(),
                	    m.getReceiver().getId(),
                	    m.getReceiver().getName(),
                	    m.getContent(),
                	    m.getTimestamp()
                	))
                .collect(Collectors.toList());
    }
}

