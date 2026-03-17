package com.YouTube.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.YouTube.Entity.Channel;
import com.YouTube.Repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository repo;
	
	public ResponseEntity<Channel> addChannel(Channel channel){
		
		return new ResponseEntity<Channel>(repo.save(channel), HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Channel>> getChannel(){
		return new ResponseEntity<List<Channel>> (repo.findAll(),HttpStatus.OK);
	}
	
	public  void delete(int id){
		 repo.deleteById(id);
	}
}
