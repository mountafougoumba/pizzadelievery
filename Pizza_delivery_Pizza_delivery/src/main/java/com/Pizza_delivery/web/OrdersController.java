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

import com.Pizza_delivery.dao.OrdersRepository;
import com.Pizza_delivery.entities.Orders;

@RestController
public class OrdersController {
	
	@Autowired
	OrdersRepository ordersRepository  ;

	/*
	 * @GetMapping("/medias") public List<Media> getAllMedias() { return
	 * mediaRepository.findAll(); }
	 */

	@GetMapping(value = "/orders/{id}")
	public ResponseEntity<Orders> getOrders(@PathVariable(name = "id") Long id) {
		try {
			Orders orders   = ordersRepository.findById(id).get();
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/orders")
	public ResponseEntity<Object> insertOrders(@RequestBody Orders orders) {
		ordersRepository.save(orders);
		return new ResponseEntity<>("orders is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/orders/{id}")
	public ResponseEntity<Object> updateOrders(@PathVariable(name = "id") Long id, @RequestBody Orders orders) {
		try {
			Orders orders2  = ordersRepository.findById(id).get();
			orders.setId(orders2.getId());
			ordersRepository.delete(orders2);
			ordersRepository.save(orders2);
			return new ResponseEntity<>("orders is Updated successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("orders with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/orders2/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable(name = "id") Long id) {
		try {
			Orders orders  = ordersRepository.findById(id).get();
			Orders orders2  = orders;
			orders.setId(orders.getId());
			ordersRepository.delete(orders);
			ordersRepository.save(orders2);
			return new ResponseEntity<>("orders is deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("orders with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	

}
