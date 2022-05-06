package com.globant.retojava.hr.repository;

// import java.util.List;

import com.globant.retojava.hr.entity.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    // @Query("From contract WHERE employeeId=?1")
    // List<Contract> findByEmployeeId(Integer employeeId);
}
