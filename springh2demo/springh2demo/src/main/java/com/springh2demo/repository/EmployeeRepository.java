package com.springh2demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springh2demo.entity.Employee;

public interface EmployeeRepository  extends  JpaRepository<Employee,Long>
{

}
