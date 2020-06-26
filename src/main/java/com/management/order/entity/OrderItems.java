package com.management.order.entity;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderItems {
	
	@Id
	private String productCode;
	
	@NotNull
	private Integer OrderId;
	
	@NotBlank(message="Product name cannot be bank")
	private String productName;
	
	@Digits(integer=100, fraction = 0)
	@NotNull(message="Quantity cannot be null")
	private Integer quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	@Override
	public String toString() {
		return "OrderItems [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	public OrderItems() {
		super();
		this.productCode = "";
		this.productName = "";
		this.quantity = 0;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

}
