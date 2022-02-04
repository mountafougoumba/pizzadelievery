package com.Pizza_delivery.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "EMPLOYEE_NAME", length = 255, nullable = false)
	private String name;

	@Column(name = "PHONE_NUMBER", length = 255, nullable = false)
	private String phone_number;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Orders> orders2 = new ArrayList<>();

	public Employee(Long id, String name, String phone_number, List<Orders> listOrderds) {
		super();
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
		this.orders = listOrderds;
	}

	public Employee() {
		super();
	}
	
	

	public Employee(String name, String phone_number) {
		super();
		this.name = name;
		this.phone_number = phone_number;
	}



	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "Processes", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Orders> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Orders> getListOrderds() {
		return orders;
	}

	public void setListOrderds(List<Orders> listOrderds) {
		this.orders = listOrderds;
	}
	
	

	public List<Orders> getOrders2() {
		return orders2;
	}

	public void setOrders2(List<Orders> orders2) {
		this.orders2 = orders2;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone_number=" + phone_number + "]";
	}

}
