package com.project.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.DTO.ProductReqDTO;
import com.project.DTO.ProductResDTO;
import com.project.Entity.Product;
import com.project.Repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	public ProductResDTO save(ProductReqDTO dto) {

		Product p = new Product();
		
		p.setName(dto.getName());
		p.setPrice(dto.getPrice());
		p.setCategory(dto.getCategory());
		p.setDescription(dto.getDescription());
		p.setImgUrl(dto.getImageUrl());

		Product saved = repo.save(p);
		
		return new ProductResDTO(
				saved.getId(), 
				saved.getName(), 
				saved.getPrice(), 
				saved.getCategory(),
				saved.getDescription(), 
				saved.getImgUrl(), 
				saved.getCreatedAt());
	}

	public List<ProductResDTO> getall() {
		return repo.findAll().stream().map(p -> new ProductResDTO(p.getId(), p.getName(), p.getPrice(), p.getCategory(),
				p.getDescription(), p.getImgUrl(), p.getCreatedAt())).collect(Collectors.toList());
	}
	
	public List<ProductResDTO> getByName(String name){
		return repo.findByName(name)
				.stream()
				.map(p -> new ProductResDTO(
					p.getId(),
					p.getName(),
					p.getPrice(),
					p.getCategory(),
					p.getDescription(),
					p.getImgUrl(),
					p.getCreatedAt()))
				.collect(Collectors.toList());
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
