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

import com.Pizza_delivery.dao.Payement_typeRepository;
import com.Pizza_delivery.entities.Payement_type;

@RestController
public class Payement_typeController {
	
	@Autowired
	Payement_typeRepository payement_typeRepository   ;

	/*
	 * @GetMapping("/medias") public List<Media> getAllMedias() { return
	 * mediaRepository.findAll(); }
	 */

	@GetMapping(value = "/payement_type/{id}")
	public ResponseEntity<Payement_type> getPayement_type(@PathVariable(name = "id") Long id) {
		try {
			Payement_type payement_type    = payement_typeRepository.findById(id).get();
			return new ResponseEntity<>(payement_type, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/payement_type")
	public ResponseEntity<Object> insertPayement_type(@RequestBody Payement_type payement_type) {
		payement_typeRepository.save(payement_type);
		return new ResponseEntity<>("payement_type is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/payement_type/{id}")
	public ResponseEntity<Object> updatePayement_type(@PathVariable(name = "id") Long id, @RequestBody Payement_type payement_type) {
		try {
			Payement_type payement_type2  = payement_typeRepository.findById(id).get();
			payement_type.setId(payement_type2.getId());
			payement_typeRepository.delete(payement_type2);
			payement_typeRepository.save(payement_type2);
			return new ResponseEntity<>("payement_type is Updated successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("payement_type with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/payement_type/{id}")
	public ResponseEntity<Object> deletePayement_type(@PathVariable(name = "id") Long id) {
		try {
			Payement_type payement_type  = payement_typeRepository.findById(id).get();
			Payement_type payement_type2  = payement_type;
			payement_type.setId(payement_type.getId());
			payement_typeRepository.delete(payement_type);
			payement_typeRepository.save(payement_type2);
			return new ResponseEntity<>("payement_type is deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("payement_type with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	


}
