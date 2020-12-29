package com.springh2demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springh2demo.entity.Employee;

public interface EmployeeRepository  extends  JpaRepository<Employee,Long>
{

	List<Employee> findByLastName(String lastName);
}
