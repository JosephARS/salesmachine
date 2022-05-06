package com.globant.sewingmachines.sales.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.globant.sewingmachines.sales.entity.SalesInventory;
import com.globant.sewingmachines.sales.entity.SalesInvoice;
import com.globant.sewingmachines.sales.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

	public ResponseEntity<Object> saveInventory(List<SalesInvoice> salesInvoice) {
		for (SalesInvoice salesInvoice2 : salesInvoice) {
			int cantidad = salesInvoice2.getQuantity();
			for (int i = 0; i < cantidad; i++) {
				SalesInventory inventory = new SalesInventory(salesInvoice2.getProduct(), 0, null,
						salesInvoice2.getInvoiceNumber(), salesInvoice2.getSaleDate(), salesInvoice2.getVendor(),
						salesInvoice2.getLocation());
				inventoryRepository.save(inventory);

			}

		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salesInvoice.toArray()).toUri();

		return ResponseEntity.created(location).build();
	}
}
