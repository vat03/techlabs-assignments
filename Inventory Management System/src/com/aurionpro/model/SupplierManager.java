package com.aurionpro.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SupplierManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Supplier> suppliers = new HashMap<>();
	private static int idCounter = 0;

	private String generateId(String prefix) {
		return prefix + (++idCounter);
	}

	public void addSupplier(String name, String contactInfo) {
		String id = generateId("S");
		suppliers.put(id, new Supplier(id, name, contactInfo));
		System.out.println("Supplier added: " + id);
	}

	public void updateSupplier(String supplierId, String name, String contactInfo) {
		Supplier supplier = suppliers.get(supplierId);
		if (supplier == null)
			throw new IllegalArgumentException("Supplier not found.");
		supplier.setName(name);
		supplier.setContactInfo(contactInfo);
		System.out.println("Supplier updated: " + supplierId);
	}

	public void deleteSupplier(String supplierId) {
		if (suppliers.remove(supplierId) != null) {
			System.out.println("Supplier deleted: " + supplierId);
		} else {
			throw new IllegalArgumentException("Supplier not found.");
		}
	}

	public void viewSupplier(String supplierId) {
		Supplier supplier = suppliers.get(supplierId);
		if (supplier != null) {
			System.out.println(supplier);
		} else {
			System.out.println("Supplier not found.");
		}
	}

	public void viewAllSuppliers() {
		suppliers.values().forEach(System.out::println);
	}

	public Map<String, Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Map<String, Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
