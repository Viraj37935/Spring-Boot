package com.project.DTO;

public class OrderResDTO {
	
	private Long orderID;
	private String userName;
	private String productName;
	private Integer quantity;
	
	public OrderResDTO(Long orderID, String userName, String productName, Integer quantity) {
		super();
		this.orderID = orderID;
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
