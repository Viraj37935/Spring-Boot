package com.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.ProductReqDTO;
import com.project.DTO.ProductResDTO;
import com.project.Service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*") 
public class ProductController {
	
	  private ProductService service;

	  public ProductController(ProductService service) {
		super();
		this.service = service;
	  }
	  
	  @PostMapping("/add")
	  public ProductResDTO addProduct(@RequestBody ProductReqDTO dto) {
		  return service.save(dto);
	  }
	  
	  @GetMapping("/get-all")
	    public List<ProductResDTO> getAll(){
	        return service.getall();
	    }
	  
	  @GetMapping("/search/{name}")
	  public List<ProductResDTO> getName(@PathVariable String name){
		  return service.getByName(name);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable Long id){
	        service.delete(id);
	    }
}
