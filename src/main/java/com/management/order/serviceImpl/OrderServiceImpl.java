package com.management.order.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.management.order.entity.Order;
import com.management.order.entity.OrderItems;
import com.management.order.exceptions.OrderNotfoundException;
import com.management.order.repository.OrderRepository;
import com.management.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	RestTemplate restTemplate;
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

//	@Autowired
//	OrderItemService orderItemService;

	@Override
	public ResponseEntity<String> createOrderDetails(Order order) {
		try {
			LOG.info("createOrderDetails---->", order);
			orderRepository.save(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("success");
	}

	@Override
	public ResponseEntity<Order> getOrderDetails(Integer orderId) {
		Order order = orderRepository.getOne(orderId);
		LOG.info("getOrderDetails---->", order);
		if (null == order)
			throw new OrderNotfoundException();
		else {
			OrderItems product = restTemplate.getForObject("http://localhost:orderitem-service/getOrdersItemDetails",
					OrderItems.class);
			LOG.info("getProductDetails---->", product);
			return ResponseEntity.ok(order);
		}
	}

}
