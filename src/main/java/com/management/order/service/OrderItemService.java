//package com.management.order.service;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.management.order.entity.OrderItems;
//
//@FeignClient(value="http://localhost:8060/")
//public interface OrderItemService {
//	
//	@GetMapping(value = "/getOrdersItemDetails")
//	public OrderItems getOrderItemDetails(@RequestParam("productId") Integer productId);
//
//}
