package com.project.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.OrderReqDTO;
import com.project.DTO.OrderResDTO;
import com.project.Service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
	
	private OrderService service;
	public OrderController(OrderService service) {
		this.service=service;
	}
	
	@PostMapping("/place")
	public OrderResDTO sendOrder(@RequestBody OrderReqDTO dto) {
		return service.placeOrder(dto);
	}
}
