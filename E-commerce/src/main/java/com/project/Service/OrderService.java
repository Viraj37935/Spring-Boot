package com.project.Service;

import org.springframework.stereotype.Service;

import com.project.DTO.OrderReqDTO;
import com.project.DTO.OrderResDTO;
import com.project.Entity.Order;
import com.project.Entity.Product;
import com.project.Entity.User;
import com.project.Repository.OrderRepository;
import com.project.Repository.ProductRepository;
import com.project.Repository.UserRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;
	private UserRepository userRepo;
	private ProductRepository productRepo;
	
	public OrderService(OrderRepository orderRepo,UserRepository userRepo,ProductRepository productRepo) {
		this.orderRepo=orderRepo;
		this.userRepo= userRepo;
		this.productRepo=productRepo;
	}
	
	public OrderResDTO placeOrder(OrderReqDTO dto){

        User user=userRepo.findById(dto.getUserId()).orElseThrow();
        Product product=productRepo.findById(dto.getProductId()).orElseThrow();

        Order order=new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(dto.getQuantity());

        Order saved=orderRepo.save(order);

        return new OrderResDTO(
            saved.getId(),
            user.getName(),
            product.getName(),
            saved.getQuantity()
        );
    }
	
}
