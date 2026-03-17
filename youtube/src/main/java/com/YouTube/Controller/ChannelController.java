package com.YouTube.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YouTube.Entity.Channel;
import com.YouTube.Service.ChannelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	private ChannelService service;

	@PostMapping("/add")
	public ResponseEntity<Channel> addChannel(@Valid @RequestBody Channel channel) {

		return service.addChannel(channel);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Channel>> getChannel() {
		return service.getChannel();

	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
