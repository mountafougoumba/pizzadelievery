package com.Pizza_delivery.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Payement_type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "PAYEMENT_TYPE", length = 255)
	private String payement_type;

	@Column(name = "TOTAL_PRICE")
	private double total_price;

	public Payement_type(Long id, String payement_type, double total_price) {
		super();
		this.id = id;
		this.payement_type = payement_type;
		this.total_price = total_price;
	}

	public Payement_type() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayement_type() {
		return payement_type;
	}

	public void setPayement_type(String payement_type) {
		this.payement_type = payement_type;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Payement_type [id=" + id + ", payement_type=" + payement_type + ", total_price=" + total_price + "]";
	}

}
