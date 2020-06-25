package com.management.order.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.order.entity.Order;
import com.management.order.repository.OrderRepository;
import com.management.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public ResponseEntity<String> createOrderDetails(Order order) {
		try {
		orderRepository.save(order);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("success");
	}

	@Override
	public Order getOrderDetails(Integer orderId) {
		Order order=null;
		try {
			order = orderRepository.getOne(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

}
