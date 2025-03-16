package com.school.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.data.entity.Employee;
import com.school.data.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
    private EmployeeRepository employeeRepository;

    // Save employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
