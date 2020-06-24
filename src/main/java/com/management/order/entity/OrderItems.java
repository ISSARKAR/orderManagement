package com.management.order.entity;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class OrderItems {
	
	private String productCode;
	private String ProductName;
	private Integer quantity;
	
	@Override
	public String toString() {
		return "OrderItems [productCode=" + productCode + ", ProductName=" + ProductName + ", quantity=" + quantity
				+ "]";
	}

	public OrderItems() {
		this.productCode = "ABC";
		ProductName = "Iphone";
		this.quantity = 2;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
