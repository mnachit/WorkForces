package com.app.service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        if(isEmployeeExist(employee.getId()))
            throw new RuntimeException("Employee already exist");
        return employeeRepository.save(employee);
    }

    public boolean isEmployeeExist(Long id){
        return employeeRepository.existsById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Employee employee){
        if(!isEmployeeExist(employee.getId()))
            throw new RuntimeException("Employee not exist");
        return employeeRepository.save(employee);
    }
}
