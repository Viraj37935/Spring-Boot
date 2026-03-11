package com.project.DTO;

import java.util.List;

public class UserResDTO {

	private Long id;

	private String name;
	private String email;
	
	
	public UserResDTO(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	List<OrderResDTO> orderdto ;
	
	public List<OrderResDTO> getOrderdto() {
		return orderdto;
	}
	
	public void setOrderdto(List<OrderResDTO> orderdto) {
		this.orderdto = orderdto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
