package com.pack.dao;

import org.springframework.data.repository.CrudRepository;

import com.pack.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
