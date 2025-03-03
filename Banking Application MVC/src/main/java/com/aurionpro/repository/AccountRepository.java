package com.aurionpro.repository;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.AccountEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountRepository {
	public void addAccount(AccountEntity account) {
		String sql = "INSERT INTO Accounts (account_number, customer_id, balance, account_type) VALUES (?, ?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, generateAccountNumber());
			stmt.setInt(2, account.getCustomerId());
			stmt.setDouble(3, account.getBalance());
			stmt.setString(4, account.getAccountType());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AccountEntity> getAccountsByCustomerId(int customerId) {
		List<AccountEntity> accounts = new ArrayList<>();
		String sql = "SELECT * FROM Accounts WHERE customer_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AccountEntity account = new AccountEntity();
				account.setAccountId(rs.getInt("account_id"));
				account.setAccountNumber(rs.getString("account_number"));
				account.setCustomerId(rs.getInt("customer_id"));
				account.setBalance(rs.getDouble("balance"));
				account.setAccountType(rs.getString("account_type"));
				account.setCreatedAt(rs.getTimestamp("created_at"));
				account.setUpdatedAt(rs.getTimestamp("updated_at"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public AccountEntity getAccountById(int accountId) {
		String sql = "SELECT * FROM Accounts WHERE account_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, accountId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				AccountEntity account = new AccountEntity();
				account.setAccountId(rs.getInt("account_id"));
				account.setAccountNumber(rs.getString("account_number"));
				account.setCustomerId(rs.getInt("customer_id"));
				account.setBalance(rs.getDouble("balance"));
				account.setAccountType(rs.getString("account_type"));
				account.setCreatedAt(rs.getTimestamp("created_at"));
				account.setUpdatedAt(rs.getTimestamp("updated_at"));
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBalance(int accountId, double newBalance) {
		String sql = "UPDATE Accounts SET balance = ? WHERE account_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDouble(1, newBalance);
			stmt.setInt(2, accountId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String generateAccountNumber() {
		Random rand = new Random();
		return "ACC" + String.format("%010d", rand.nextInt(1000000000));
	}
}