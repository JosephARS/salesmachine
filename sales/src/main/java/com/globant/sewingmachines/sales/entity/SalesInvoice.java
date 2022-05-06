package com.globant.sewingmachines.sales.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int invoiceNumber;
	private double amount;
	private int product;
	private int quantity;
	private String description;
	private Date saleDate;
	private int vendor;
	private int client;
	private String location;
	
	public SalesInvoice() {
		
	}

	public SalesInvoice(int id, int invoiceNumber, double amount, int product, int quantity, String description,
			Date saleDate, int vendor, int client, String location) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.amount = amount;
		this.product = product;
		this.quantity = quantity;
		this.description = description;
		this.saleDate = saleDate;
		this.vendor = vendor;
		this.client = client;
		this.location = location;
	}
	
	
	public SalesInvoice( int invoiceNumber, double amount, int product, int quantity, String description,
			Date saleDate, int vendor, int client, String location) {

		this.invoiceNumber = invoiceNumber;
		this.amount = amount;
		this.product = product;
		this.quantity = quantity;
		this.description = description;
		this.saleDate = saleDate;
		this.vendor = vendor;
		this.client = client;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getVendor() {
		return vendor;
	}

	public void setVendor(int vendor) {
		this.vendor = vendor;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesInvoice other = (SalesInvoice) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "SalesInvoice [id=" + id + ", invoiceNumber=" + invoiceNumber + ", amount=" + amount + ", product="
				+ product + ", quantity=" + quantity + ", description=" + description + ", saleDate=" + saleDate
				+ ", vendor=" + vendor + ", client=" + client + ", location=" + location + "]";
	}
	
	
	
	
	
	
}
