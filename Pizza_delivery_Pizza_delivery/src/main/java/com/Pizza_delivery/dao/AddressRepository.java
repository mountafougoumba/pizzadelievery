package com.Pizza_delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telemedecineBE.entities.Address;

public interface AddressRepository  
					extends JpaRepository<Address, Long>{

}
