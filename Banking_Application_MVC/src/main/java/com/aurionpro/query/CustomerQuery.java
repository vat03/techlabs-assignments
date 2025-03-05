package com.aurionpro.query;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.CustomerEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerQuery {
	private AccountQuery accountQuery = new AccountQuery();

	public void addCustomer(CustomerEntity customer) {
		String sql = "INSERT INTO customers (user_id, first_name, last_name) VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, customer.getUserId());
			stmt.setString(2, customer.getFirstName());
			stmt.setString(3, customer.getLastName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> customers = new ArrayList<>();
		String sql = "SELECT * FROM customers";
		try (Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setUserId(rs.getInt("user_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				// Fetch accounts for this customer
				customer.setAccounts(accountQuery.getAccountsByCustomerId(customer.getCustomerId()));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public CustomerEntity getCustomerById(int customerId) {
		String sql = "SELECT * FROM customers WHERE customer_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setUserId(rs.getInt("user_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setAccounts(accountQuery.getAccountsByCustomerId(customerId));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CustomerEntity getCustomerByUserId(int userId) {
		String sql = "SELECT * FROM customers WHERE user_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setUserId(rs.getInt("user_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setAccounts(accountQuery.getAccountsByCustomerId(customer.getCustomerId()));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateCustomer(CustomerEntity customer) {
		String sql = "UPDATE customers SET first_name = ?, last_name = ? WHERE customer_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setInt(3, customer.getCustomerId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
