package com.Pizza_delivery.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.telemedecineBE.entities.Address;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "CUSTOMER_NAME",nullable = false,length = 255)
	private String customer_name;
	private String phone;
	private String type_payements;
	
	@JoinColumn(name="address_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
	
	
	public Customer() {
		super();
	}
	public Customer(Long id, String customer_name, String phone, String type_payements) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.phone = phone;
		this.type_payements = type_payements;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType_payements() {
		return type_payements;
	}
	public void setType_payements(String type_payements) {
		this.type_payements = type_payements;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_name=" + customer_name + ", phone=" + phone + ", type_payements="
				+ type_payements + "]";
	}
	
	
	

}
