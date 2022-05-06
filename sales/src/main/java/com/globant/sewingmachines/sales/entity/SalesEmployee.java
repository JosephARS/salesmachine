package com.globant.sewingmachines.sales.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String user;
	private char state;
	
	public SalesEmployee() {
		
	}
	
	
	public SalesEmployee(int id, String firstName, String lastName, String user, char state) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.state = state;
	}



	public SalesEmployee(String firstName, String lastName, String user, char state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public char getState() {
		return state;
	}


	public void setState(char state) {
		this.state = state;
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
		SalesEmployee other = (SalesEmployee) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "SalesEmployee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", user=" + user
				+ ", state=" + state + "]";
	}





	
	
	
	

}
