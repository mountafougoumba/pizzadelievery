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

import com.Pizza_delivery.dao.AddressRepository;
import com.telemedecineBE.entities.Address;

@RestController
public class AddressController {
	@Autowired
	AddressRepository addressRepository;

	/*
	 * @GetMapping("/medias") public List<Media> getAllMedias() { return
	 * mediaRepository.findAll(); }
	 */

	@GetMapping(value = "/addresses/{id}")
	public ResponseEntity<Address> getAddresse(@PathVariable(name = "id") Long id) {
		try {
			Address adresse = addressRepository.findById(id).get();
			return new ResponseEntity<>(adresse, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/addresses")
	public ResponseEntity<Object> insertAddresse(@RequestBody Address adresse) {
		addressRepository.save(adresse);
		return new ResponseEntity<>("Addresse is created successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/addresses/{id}")
	public ResponseEntity<Object> updateAddresse(@PathVariable(name = "id") Long id, @RequestBody Address address) {
		try {
			Address adresse2 = addressRepository.findById(id).get();
			address.setId(adresse2.getId());
			addressRepository.delete(adresse2);
			addressRepository.save(adresse2);
			return new ResponseEntity<>("Addresse is Updated successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Addresse with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/addresses/{id}")
	public ResponseEntity<Object> deleteAddresse(@PathVariable(name = "id") Long id) {
		try {
			Address adresse = addressRepository.findById(id).get();
			Address adresse2 = adresse;
			adresse2.setId(adresse.getId());
			addressRepository.delete(adresse);
			addressRepository.save(adresse2);
			return new ResponseEntity<>("Addresse is deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Addresse with that ID does not exist", HttpStatus.NOT_FOUND);
		}

	}

}
