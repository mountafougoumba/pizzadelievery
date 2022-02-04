package com.Pizza_delivery.web;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.Pizza_delivery.dao.CustomerRepository;
import com.Pizza_delivery.entities.Customer;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository ;
	

	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(name = "id") Long id) {
		try {
			Customer customer = customerRepository.findById(id).get();
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/customer")
	public ResponseEntity<Object> insertCustomer(@RequestBody Customer customer ) {
		customerRepository.save(customer);
		return new ResponseEntity<>("customer is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer customer1) {
		try {
			Customer customer  = customerRepository.findById(id).get();
			customer1.setId(customer.getId());
			customerRepository.delete(customer);
			customerRepository.save(customer);
			return new ResponseEntity<>("customer is Updated successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("customer with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/customer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable(name = "id") Long id) {
		try {
			Customer customer = customerRepository.findById(id).get();
			Customer customer2 = customer;
			customer2.setId(customer.getId());
			customerRepository.delete(customer);
			customerRepository.save(customer2);
			return new ResponseEntity<>("customer is deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("customer with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	


}
