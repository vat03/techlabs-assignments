package com.aurionpro.model;

import java.io.Serializable;

public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;
	private String supplierId;
	private String name;
	private String contactInfo;

	// Constructor
	public Supplier(String supplierId, String name, String contactInfo) {
		this.supplierId = supplierId;
		this.name = name;
		this.contactInfo = contactInfo;
	}

	// Getters
	public String getSupplierId() {
		return supplierId;
	}

	public String getName() {
		return name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	// Setters
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "Supplier [ID=" + supplierId + ", Name=" + name + ", Contact=" + contactInfo + "]";
	}
}
