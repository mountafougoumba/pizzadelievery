package com.Pizza_delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pizza_delivery.entities.Employee;

public interface EmployeeRepository 
							extends JpaRepository<Employee, Long>{

}
