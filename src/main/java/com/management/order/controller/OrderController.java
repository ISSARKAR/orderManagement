package com.management.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.management.order.entity.Order;
import com.management.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@HystrixCommand(fallbackMethod = "getOrderDetailsFallback", groupKey = "getOrderDetails", commandKey = "getOrderDetails")
	@GetMapping(value = "/getOrders", produces = "application/json")
	public Order getOrderDetails(@RequestParam("orderId") Integer orderId) {
		return orderService.getOrderDetails(orderId);
	}

	public Order getOrderDetailsFallback(Integer orderId) {
		return null;
	}

	@HystrixCommand(fallbackMethod = "createOrdersFallback", groupKey = "createOrders", commandKey = "createOrders")
	@PutMapping(value = "/createOrder")
	public ResponseEntity<String> createOrders(@RequestBody Order order) {
		return orderService.createOrderDetails(order);
	}

	public ResponseEntity<String> createOrdersFallback(Order order) {
		return ResponseEntity.ok(HttpStatus.NO_CONTENT.toString());
	}

}
