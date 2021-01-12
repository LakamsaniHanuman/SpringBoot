package com.pack.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.CustomerRepository;
import com.pack.model.Customer;

 


 

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ConsumerController {

 

    @Autowired
    CustomerRepository repository;
    
    
    
    @PostMapping(value = "/customers")
      public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        try {
          Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge(),customer.getGender()));
          return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
      }    
        
    
    
}