package com.Pizza_delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pizza_delivery.entities.Customer;

public interface CustomerRepository 
						extends JpaRepository<Customer, Long>{

}
