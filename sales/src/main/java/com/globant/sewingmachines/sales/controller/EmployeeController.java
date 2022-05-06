package com.globant.sewingmachines.sales.controller;


import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.globant.sewingmachines.sales.entity.SalesEmployee;
import com.globant.sewingmachines.sales.repository.EmployeeRepository;




@RestController
public class EmployeeController {
	
	private static final char ALTA_EMPLOYEE = 'A';
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@RequestMapping(value = "/get-employee/{user}", method = RequestMethod.GET)
	public SalesEmployee getEmployeeByUser(@PathVariable String user) {
		return employeeRepository.findByUser(user);
	}
	
	@RequestMapping(value = "/get-list-employees", method = RequestMethod.GET)
	public SalesEmployee getListEmployeeByUser(@PathVariable String user) {
		return employeeRepository.findByUser(user);
	}
	
	@PutMapping(value = "/alta-employee/{user}")
	public ResponseEntity<Object> altaEmployee(@PathVariable String user) {
		SalesEmployee employee1 = employeeRepository.findByUser(user);
		employee1.setState(ALTA_EMPLOYEE);
		SalesEmployee savedEmployee = employeeRepository.save(employee1);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	

	@PutMapping("update-employee/{user}")
	public ResponseEntity<Object> updateEmployee(@PathVariable String user,@RequestBody SalesEmployee employee) {
		SalesEmployee newEmployee = employeeRepository.findByUser(user);
		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setUser(employee.getUser());
		newEmployee.setState(employee.getState());
		

		SalesEmployee savedEmployee = employeeRepository.save(newEmployee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	


}
