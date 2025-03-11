package com.aurionpro.query;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.CustomerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerQuery {
    private AccountQuery accountQuery = new AccountQuery();

    public void addCustomer(CustomerEntity customer, int userId) {
        String sql = "INSERT INTO customers (user_id, first_name, last_name) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public List<CustomerEntity> getAllCustomers(String sortField, String sortOrder) {
        List<CustomerEntity> customers = new ArrayList<>();
        String validSortField = "customer_id"; // Default
        if (sortField != null && (sortField.equals("customer_id") || sortField.equals("first_name") || 
            sortField.equals("last_name") || sortField.equals("balance"))) {
            validSortField = sortField;
        }
        String validSortOrder = "ASC"; // Default
        if (sortOrder != null && sortOrder.equals("DESC")) {
            validSortOrder = "DESC";
        }

        String sql = "SELECT c.* FROM customers c";
        if (validSortField.equals("balance")) {
            sql = "SELECT c.*, a.balance FROM customers c " +
                  "LEFT JOIN accounts a ON c.customer_id = a.customer_id " +
                  "ORDER BY a.balance " + validSortOrder + ", c.customer_id " + validSortOrder;
        } else {
            sql += " ORDER BY " + validSortField + " " + validSortOrder;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CustomerEntity customer = new CustomerEntity();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setUserId(rs.getInt("user_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAccounts(accountQuery.getAccountsByCustomerId(customer.getCustomerId()));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<CustomerEntity> getFilteredCustomers(String customerId, String firstName, String lastName,
            String balance, String accountNumber, String accountType, String sortField, String sortOrder) {
        StringBuilder sql = new StringBuilder(
            "SELECT DISTINCT c.*, a.account_number, a.account_type, a.balance " +
            "FROM customers c LEFT JOIN accounts a ON c.customer_id = a.customer_id WHERE 1=1"
        );
        List<Object> params = new ArrayList<>();

        if (customerId != null && !customerId.isEmpty()) {
            sql.append(" AND c.customer_id = ?");
            params.add(Integer.parseInt(customerId));
        }
        if (firstName != null && !firstName.isEmpty()) {
            sql.append(" AND c.first_name LIKE ?");
            params.add("%" + firstName + "%");
        }
        if (lastName != null && !lastName.isEmpty()) {
            sql.append(" AND c.last_name LIKE ?");
            params.add("%" + lastName + "%");
        }
        if (balance != null && !balance.isEmpty()) {
            sql.append(" AND a.balance = ?");
            params.add(Double.parseDouble(balance));
        }
        if (accountNumber != null && !accountNumber.isEmpty()) {
            sql.append(" AND a.account_number LIKE ?");
            params.add("%" + accountNumber + "%");
        }
        if (accountType != null && !accountType.isEmpty()) {
            sql.append(" AND a.account_type = ?");
            params.add(accountType);
        }

        String validSortField = "c.customer_id"; // Default sort
        if (sortField != null && (sortField.equals("customer_id") || sortField.equals("first_name") || 
            sortField.equals("last_name") || sortField.equals("balance") || sortField.equals("account_number"))) {
            if (sortField.equals("account_number")) {
                validSortField = "CAST(a.account_number AS UNSIGNED)"; // Cast to integer for numeric sorting
            } else if (sortField.equals("balance")) {
                validSortField = "a.balance";
            } else {
                validSortField = "c." + sortField;
            }
        }
        String validSortOrder = "ASC"; // Default
        if (sortOrder != null && sortOrder.equalsIgnoreCase("DESC")) {
            validSortOrder = "DESC";
        }
        sql.append(" ORDER BY ").append(validSortField).append(" ").append(validSortOrder)
           .append(", c.customer_id ASC"); // Secondary sort for consistency

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            ResultSet rs = stmt.executeQuery();
            List<CustomerEntity> customers = new ArrayList<>();
            while (rs.next()) {
                CustomerEntity customer = new CustomerEntity();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setUserId(rs.getInt("user_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setAccounts(accountQuery.getAccountsByCustomerId(customer.getCustomerId()));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}