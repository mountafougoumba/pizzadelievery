package com.Pizza_delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pizza_delivery.entities.Payement_type;

public interface Payement_typeRepository 
		extends JpaRepository<Payement_type, Long>{

}
