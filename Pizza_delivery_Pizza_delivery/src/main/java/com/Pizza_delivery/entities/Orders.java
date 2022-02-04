package com.Pizza_delivery.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "TOTAL_PRICE")
	private double total_price;
	private String order_name;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	public Orders(double total_price, String order_name) {
		super();
		this.total_price = total_price;
		this.order_name = order_name;
	}

	public Orders(Long id, double total_price, String order_name, List<Employee> employeeList) {
		super();
		this.id = id;
		this.total_price = total_price;
		this.order_name = order_name;
		this.employeeList = employeeList;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	@ManyToMany(mappedBy = "orders")
	private List<Employee> employeeList = new ArrayList<>();

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total_price=" + total_price + ", order_name=" + order_name + "]";
	}

}
