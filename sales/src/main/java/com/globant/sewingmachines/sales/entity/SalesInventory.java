package com.globant.sewingmachines.sales.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int product;
	private int purshaseReceipt;
	private Date purshaseDate;
	private int salesReceipt;
	private Date salesDate;
	private int vendor;
	private String location;
	
	public SalesInventory() {
		
	}

	public SalesInventory(int id, int product, int purshaseReceipt, Date purshaseDate, int salesReceipt, Date salesDate,
			int vendor, String location) {
		this.id = id;
		this.product = product;
		this.purshaseReceipt = purshaseReceipt;
		this.purshaseDate = purshaseDate;
		this.salesReceipt = salesReceipt;
		this.salesDate = salesDate;
		this.vendor = vendor;
		this.location = location;
	}
	
	public SalesInventory(int product, int purshaseReceipt, Date purshaseDate, int salesReceipt, Date salesDate,
			int vendor, String location) {
		this.product = product;
		this.purshaseReceipt = purshaseReceipt;
		this.purshaseDate = purshaseDate;
		this.salesReceipt = salesReceipt;
		this.salesDate = salesDate;
		this.vendor = vendor;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getPurshaseReceipt() {
		return purshaseReceipt;
	}

	public void setPurshaseReceipt(int purshaseReceipt) {
		this.purshaseReceipt = purshaseReceipt;
	}

	public Date getPurshaseDate() {
		return purshaseDate;
	}

	public void setPurshaseDate(Date purshaseDate) {
		this.purshaseDate = purshaseDate;
	}

	public int getSalesReceipt() {
		return salesReceipt;
	}

	public void setSalesReceipt(int salesReceipt) {
		this.salesReceipt = salesReceipt;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getVendor() {
		return vendor;
	}

	public void setVendor(int vendor) {
		this.vendor = vendor;
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
		SalesInventory other = (SalesInventory) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "SalesInventory [id=" + id + ", product=" + product + ", purshaseReceipt=" + purshaseReceipt
				+ ", purshaseDate=" + purshaseDate + ", salesReceipt=" + salesReceipt + ", salesDate=" + salesDate
				+ ", vendor=" + vendor + ", location=" + location + "]";
	}
	
	
	
	
}
