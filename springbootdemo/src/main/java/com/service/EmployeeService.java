package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.entity.Employee;
import com.exception.RecordNotFoundException;

@Service
public class EmployeeService {
    @Autowired
	private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee)
    {
    	employeeRepository.save(employee);
    	return employee;
    }
    
    public Employee getEmployeebyId(int empId) throws RecordNotFoundException
    {
    	Optional<Employee> optional=employeeRepository.findById(empId);
    	if(optional.isPresent())
    	{
    		return optional.get();
    	}
    	else
    	{
    		throw new RecordNotFoundException("No such record");
    	}
    }
    public List<Employee> getAllEmployee()
    {
    	List<Employee> listOfEmployee = (List<com.entity.Employee>) employeeRepository.findAll();
        return listOfEmployee;
    }
    public  Employee updateEmployee(Employee employee)
    {
    	return employeeRepository.save(employee);
    }
    
    public void deleteEmployee(int empId) throws RecordNotFoundException
    {
    	Optional<Employee> optional=employeeRepository.findById(empId);
    	if(optional.isPresent())
    	{
    		 employeeRepository.deleteById(empId);
    	}
    	else
    	{
    		throw new RecordNotFoundException("No such record");
    	}
    }
}