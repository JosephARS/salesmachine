package com.globant.sewingmachines.sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.sewingmachines.sales.entity.SalesEmployee;

@Repository
public interface EmployeeRepository extends JpaRepository<SalesEmployee, Integer>{
	SalesEmployee findByUser(String user);
}
