package com.globant.sewingmachines.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.globant.sewingmachines.sales.entity.SalesInvoice;
import com.globant.sewingmachines.sales.repository.SalesInvoiceRepository;
import com.globant.sewingmachines.sales.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private SalesInvoiceRepository salesInvoiceRepository;

	@PostMapping(value = "/record-payment/{salesInvoiceNumber}")
	public ResponseEntity<Object> getEmployeeByUser(@PathVariable String salesInvoiceNumber) {
		int newSalesInvoiceNumber = Integer.parseInt(salesInvoiceNumber);
		List<SalesInvoice> salesInvoice = salesInvoiceRepository.findByInvoiceNumber(newSalesInvoiceNumber);

		return inventoryService.saveInventory(salesInvoice);
	}

}
