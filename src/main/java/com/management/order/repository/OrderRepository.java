package com.management.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
