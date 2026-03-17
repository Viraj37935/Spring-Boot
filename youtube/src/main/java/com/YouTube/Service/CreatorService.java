package com.YouTube.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.YouTube.Entity.Creator;
import com.YouTube.Repository.CreatorRepository;

@Service
public class CreatorService {
	
	@Autowired
	private CreatorRepository repo;
	
	public ResponseEntity<Creator> addCreator(Creator creator){
		
		return new ResponseEntity<Creator>(repo.save(creator), HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Creator>> getCreator(){
		return new ResponseEntity<List<Creator>> (repo.findAll(),HttpStatus.OK);
	}
}
