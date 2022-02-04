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

import com.Pizza_delivery.dao.EmployeeRepository;
import com.Pizza_delivery.entities.Employee;
import com.telemedecineBE.entities.Address;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository ;

	/*
	 * @GetMapping("/medias") public List<Media> getAllMedias() { return
	 * mediaRepository.findAll(); }
	 */

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") Long id) {
		try {
			Employee employee  = employeeRepository.findById(id).get();
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/employee")
	public ResponseEntity<Object> insertAddresse(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new ResponseEntity<>("employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
		try {
			Employee employee2 = employeeRepository.findById(id).get();
			employee.setId(employee2.getId());
			employeeRepository.delete(employee2);
			employeeRepository.save(employee2);
			return new ResponseEntity<>("employee is Updated successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("employee with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(name = "id") Long id) {
		try {
			Employee employee  = employeeRepository.findById(id).get();
			Employee employee2  = employee;
			employee2.setId(employee.getId());
			employeeRepository.delete(employee);
			employeeRepository.save(employee2);
			return new ResponseEntity<>("employee is deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("employee with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	

}
