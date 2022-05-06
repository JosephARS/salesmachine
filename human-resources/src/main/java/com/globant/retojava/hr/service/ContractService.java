package com.globant.retojava.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import com.globant.retojava.hr.entity.Contract;
import com.globant.retojava.hr.repository.ContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public List<Contract> All() {
        return contractRepository.findAll();
    }

    // public List<Contract> findByEmployeeId(Integer employeeId) {
    //     return contractRepository.findByEmployeeId(employeeId);
    // }

    public void saveContract(Contract contract) {
        contract = contractRepository.saveAndFlush(contract);
    }
}
