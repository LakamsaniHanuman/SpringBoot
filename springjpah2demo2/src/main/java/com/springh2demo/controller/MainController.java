package com.springh2demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springh2demo.appexception.RecordNotFoundException;
import com.springh2demo.entity.Employee;
import com.springh2demo.service.EmployeeService;

@RestController
public class MainController {
	@Autowired
	private EmployeeService service;

	 @GetMapping(value = "/getall")
	public ResponseEntity<List<Employee>> getAllEmployees() {
	List<Employee> list = service.getAllEmployees();

	 return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	 @GetMapping("fetch/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
	Employee entity = service.getEmployeeById(id);

	 return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	 @PostMapping(value = "/create")
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) throws RecordNotFoundException {
	Employee updated = service.createOrUpdateEmployee(employee);
	return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	 @DeleteMapping("del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
	service.deleteEmployeeById(id);
	return HttpStatus.FORBIDDEN;
	}
   @GetMapping("read/{lastname}")
   public List<Employee> readByLastName(@PathVariable("lastname") String lastName)
   {
	   return service.findByLastName(lastName);
   }
}
