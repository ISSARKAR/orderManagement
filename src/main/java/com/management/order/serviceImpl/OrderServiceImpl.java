package com.management.order.serviceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.order.entity.Order;
import com.management.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public Order getOrderDetails() {
		return new Order();
	}

	@Override
	public ResponseEntity<String> createOrderDetails() {
		return null;
	}

}
