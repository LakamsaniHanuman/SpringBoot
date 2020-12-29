package com.springh2demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springh2demo.appexception.RecordNotFoundException;
import com.springh2demo.entity.Employee;
import com.springh2demo.repository.EmployeeRepository;

@Service
public class EmployeeService
{
    @Autowired
	private EmployeeRepository employeeRepository;
    
    public List<Employee> getAllEmployees()
    {
    List<Employee> employeeList = employeeRepository.findAll();
    if(employeeList.size() > 0) 
    {
    return employeeList;
    }
    else 
    {
    return new ArrayList<Employee>();
    }
    }
    public Employee getEmployeeById(Long id) throws RecordNotFoundException
    {
    Optional<Employee> employee = employeeRepository.findById(id);
    if(employee.isPresent()) 
    {
    return employee.get();
    }
    else 
    {
    throw new RecordNotFoundException("No employee record exist for given id");
    }
    }
    public Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException
    {
    Optional<Employee> employeeExisting = employeeRepository.findById(employee.getId());
    if(employeeExisting.isPresent())
    {
    Employee oldEntity = employeeExisting.get();
    oldEntity.setFirstName(employee.getFirstName());
    oldEntity.setLastName(employee.getLastName());
    oldEntity.setEmail(employee.getEmail());
    employee = employeeRepository.save(oldEntity);
    return employee;
    }
    else
    {
    employee = employeeRepository.save(employee);
    return employee;
    }
    }
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
    Optional<Employee> employee = employeeRepository.findById(id);
    if(employee.isPresent())
    {
    employeeRepository.deleteById(id);
    } else {
    throw new RecordNotFoundException("No employee record exist for given id");
    }
    }
    
    public List<Employee> findByLastName(String lastName)
    {
    	return employeeRepository.findByLastName(lastName);
    }
    }
