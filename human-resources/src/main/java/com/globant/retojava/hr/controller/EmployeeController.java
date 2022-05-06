package com.globant.retojava.hr.controller;

import java.util.List;

import com.globant.retojava.hr.dto.*;
import com.globant.retojava.hr.entity.*;
import com.globant.retojava.hr.service.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ContractService contractService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> All() {
        var list = employeeService.All();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    // @GetMapping("")
    // public ResponseEntity<?> findByName(@RequestParam(name = "name", required = true) String name) {
    //     var employee = employeeService.findByName(name);
    //     return new ResponseEntity<>(employee, HttpStatus.OK);
    // }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        var employee = employeeService.getEmployee(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Not exists"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        if (StringUtils.isBlank(employeeDto.getName())) {
            return new ResponseEntity<>(new Message("The Name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee(0, employeeDto.getName(), false);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        if (StringUtils.isBlank(employeeDto.getName())) {
            return new ResponseEntity<>(new Message("The Name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        var employee = employeeService.getEmployee(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(new Message("Not exists"), HttpStatus.NOT_FOUND);
        }
        var employeeReal = employee.get();
        employeeReal.setName(employeeDto.getName());
        employeeService.saveEmployee(employeeReal);
        return new ResponseEntity<>(employeeReal, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> enabledEmployee (@PathVariable Integer id, @RequestParam boolean enabled){
        var employee = employeeService.getEmployee(id);
        if(!employee.isPresent()){
            return new ResponseEntity<>(new Message("Not exists"), HttpStatus.NOT_FOUND);
        }
        var employeeReal=employee.get();
        employeeReal.setEnabled(enabled);
        employeeService.saveEmployee(employeeReal);
        return new ResponseEntity<>(employeeReal, HttpStatus.OK);
    }
    @PatchMapping("/contract/{id}")
    public ResponseEntity<?> createContract(@PathVariable Integer Id, @RequestBody ContractDto contractDto){
        var contract = new Contract();
        contract.setEmployeeId(Id);
        contract.setCharge(contractDto.getCharge());

        contractService.saveContract(contract);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    } 

}
