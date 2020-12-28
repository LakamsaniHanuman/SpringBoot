package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.exception.RecordNotFoundException;
import com.service.EmployeeService;

@RestController
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/one")
	public String testEmployee() {
		return "Welcome Employee";
	}

	@PostMapping(value = "create")
	public Employee createMethod(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/readbyid/{alias}")
	public Employee readMethod(@PathVariable("alias") int empNo) {
		Employee employee = null;
		try {
			employee = employeeService.getEmployeebyId(empNo);
		} catch (RecordNotFoundException e) {

			System.out.println(e.getMessage());
		}
		return employee;
	}

	@GetMapping(value = "all")
	public List readAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@DeleteMapping(value = "/delete/{alias}")
	public void deleteEmployee(@PathVariable("alias") int empNo) throws RecordNotFoundException {
	 employeeService.deleteEmployee(empNo);
	}
	@PutMapping(value="update")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
		return employee;
	}

}
