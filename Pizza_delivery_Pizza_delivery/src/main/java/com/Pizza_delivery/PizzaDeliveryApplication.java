package com.Pizza_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Pizza_delivery.dao.AddressRepository;
import com.Pizza_delivery.dao.EmployeeRepository;
import com.Pizza_delivery.entities.Employee;
import com.telemedecineBE.entities.Address;



@ComponentScan(basePackages = { "com.Pizza_delivery" })
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PizzaDeliveryApplication {

	Employee employee = new Employee("Mamadou Mountagha Barry", "6469917193");

	public static void main(String[] args) {
		ApplicationContext Apctx = SpringApplication.run(PizzaDeliveryApplication.class, args);
		EmployeeRepository employeeRepository = Apctx.getBean(EmployeeRepository.class);
		AddressRepository addressRepository = Apctx.getBean(AddressRepository.class);
		Employee employee2 = new Employee("OUMAR BALde", "5555654554");
		employeeRepository.save(employee2);
		

	}

}
