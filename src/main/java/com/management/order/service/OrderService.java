package com.management.order.service;

import org.springframework.http.ResponseEntity;

import com.management.order.entity.Order;

public interface OrderService {

	ResponseEntity<Order> getOrderDetails(Integer orderId);
	ResponseEntity<String> createOrderDetails(Order order);

}
