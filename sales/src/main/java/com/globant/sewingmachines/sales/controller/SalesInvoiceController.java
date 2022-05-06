package com.globant.sewingmachines.sales.controller;


import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amazonaws.services.sns.model.PublishRequest;
import com.globant.sewingmachines.sales.entity.SalesInvoice;
import com.globant.sewingmachines.sales.repository.SalesInvoiceRepository;




@RestController
public class SalesInvoiceController {
	

	@Autowired
	private SalesInvoiceRepository salesInvoiceRepository;
	@Autowired
	private SNSController snsController;
	

	@RequestMapping(value = "/get-sales-invoice/{id}", method = RequestMethod.GET)
	public SalesInvoice getSalesInvoice(@PathVariable String id) {
		int salesInvoiceId = Integer.parseInt(id);
        return salesInvoiceRepository.findById(salesInvoiceId);
	}
	
	@RequestMapping(value = "/get-list-sales-invoice", method = RequestMethod.GET)
	public List<SalesInvoice> getListSalesInvoice() {

        return salesInvoiceRepository.findAll();
	}
	
	@PostMapping(value = "/upload-sales-invoice")
	public ResponseEntity<Object> uploadSalesInvoice(@RequestBody SalesInvoice salesInvoice) {
	
		SalesInvoice savedSalesInvoice = salesInvoiceRepository.save(salesInvoice);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSalesInvoice.getId()).toUri();
				 
		return ResponseEntity.created(location).build();
	}
	

	@PostMapping(value = "/upload-list-sales-invoice")
	public ResponseEntity<Object> uploadListSalesInvoice(@RequestBody List<SalesInvoice> salesInvoice) {
	
		List<SalesInvoice> savedSalesInvoice = salesInvoiceRepository.saveAll(salesInvoice);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSalesInvoice.toArray()).toUri();
				 
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/publish-weekly-sales")
	public String publishWeeklySales(@RequestBody String listSalesInvoice) {
		snsController.publish(listSalesInvoice);
		return "Report Sended";
		
	}
	
	@GetMapping("/publish-weekly-sales-db")
	public String publishWeeklySalesDb() {
		String weeklySalesreport = salesInvoiceRepository.findAll().toString();
		
		snsController.publish(weeklySalesreport);
		return "Report Sended";
		
	}


}
