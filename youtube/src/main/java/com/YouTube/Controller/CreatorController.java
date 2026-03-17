package com.YouTube.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YouTube.Entity.Creator;
import com.YouTube.Service.CreatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/creator")
public class CreatorController {

	@Autowired
	private CreatorService service;

	@PostMapping("/add")
	public ResponseEntity<Creator> addCreator(@Valid @RequestBody Creator create) {

		return service.addCreator(create);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Creator>> getCreator() {
		return service.getCreator();

	}

}
