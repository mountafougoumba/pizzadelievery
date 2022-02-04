package com.Pizza_delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pizza_delivery.entities.Orders;

public interface OrdersRepository
		extends JpaRepository<Orders, Long>{

}
