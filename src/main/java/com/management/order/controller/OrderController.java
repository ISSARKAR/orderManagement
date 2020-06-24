package com.management.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.order.entity.Order;
import com.management.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RefreshScope
public class OrderController {

	@Autowired
	OrderService orderService;

	@HystrixCommand(fallbackMethod = "getOrderDetailsFallback", groupKey = "getOrderDetails", commandKey = "getOrderDetails")
	@GetMapping("/getOrders")
	public Order getOrderDetails() {
		return orderService.getOrderDetails();
	}

	@HystrixCommand(fallbackMethod = "createOrdersFallback", groupKey = "createOrders", commandKey = "createOrders")
	@PutMapping("/createOrder")
	public ResponseEntity<String> createOrders(Order order) {
		return orderService.createOrderDetails();
	}
	
	public Order getOrderDetailsFallback() {
		return new Order();
	}
	
	public ResponseEntity<String> createOrdersFallback() {
		return null;
	}
	
	@HystrixCommand(fallbackMethod = "getValueFallback", groupKey = "getValue", commandKey = "getValue")
	@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	@GetMapping("/getValue")
	public String getValue() {
		return "hello";
	}
	
	public String getValueFallback() {
		return "hello users";
	}
	
	

}
