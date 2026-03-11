package com.project.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.project.DTO.ProductReqDTO;

import com.project.Service.ProductService;

//import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceTest {

	@Autowired
	private ProductService service;

	@Test
	public void checkcatageryadd() {
		ProductReqDTO test = new ProductReqDTO();
		test.setCategory("Mouse");
		test.setName("AnteSport");
		test.setPrice(800.0);

		ProductReqDTO test2 = test;
		assertEquals("Mouse", test2.getName());
		System.out.println("Demo Test");
	}
}
