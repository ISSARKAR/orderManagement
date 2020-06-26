package com.management.order.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.order.entity.OrderItems;

@FeignClient("orderitem-service")
public interface OrderFeign {
	
	@GetMapping(value = "/getAllItems")
	public ResponseEntity<List<OrderItems>> getAllItems(@RequestParam("orderId") Integer orderId);

}
