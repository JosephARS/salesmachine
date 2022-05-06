package com.globant.retojava.hr.repository;

// import java.util.List;
// import java.util.Optional;

import com.globant.retojava.hr.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository 
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //  Optional <Employee> findByNameEmployee(String nameEmployee);
}
