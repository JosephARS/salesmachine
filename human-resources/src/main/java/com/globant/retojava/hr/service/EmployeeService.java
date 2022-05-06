package com.globant.retojava.hr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.globant.retojava.hr.entity.Employee;
import com.globant.retojava.hr.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> All() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    // public Optional<Employee> findByName(String name) {
    //     return employeeRepository.findByNameEmployee(name);
    // }

    public void saveEmployee(Employee employee) {
        employee = employeeRepository.saveAndFlush(employee);
    }

}
