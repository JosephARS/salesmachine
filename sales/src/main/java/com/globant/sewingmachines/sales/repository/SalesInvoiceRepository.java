package com.globant.sewingmachines.sales.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.sewingmachines.sales.entity.SalesInvoice;

@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Integer>{
	SalesInvoice findById(int id);
	
	List<SalesInvoice> findByInvoiceNumber(int invoiceNumber);
}
