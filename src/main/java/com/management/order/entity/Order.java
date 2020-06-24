package com.management.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Order {
	
	private String customerName;
	private Date OrderDate;
	private String shippingAddress;
	private BigDecimal totalInDollars;
	private List<OrderItems> orderItems;
	
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", OrderDate=" + OrderDate + ", shippingAddress="
				+ shippingAddress + ", totalInDollars=" + totalInDollars + ", orderItems=" + orderItems + "]";
	}

	public Order() {
		this.customerName = "Ishani";
		OrderDate = new Date();
		this.shippingAddress = "Hyderabad";
		this.totalInDollars = new BigDecimal(2000000.0);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BigDecimal getTotalInDollars() {
		return totalInDollars;
	}

	public void setTotalInDollars(BigDecimal totalInDollars) {
		this.totalInDollars = totalInDollars;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	

}
