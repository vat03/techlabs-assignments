package com.aurionpro.query;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.AdminEntity;
import java.sql.*;

public class AdminQuery {
	public void addAdmin(AdminEntity admin) {
		String sql = "INSERT INTO admins (user_id, first_name, last_name) VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, admin.getUserId());
			stmt.setString(2, admin.getFirstName());
			stmt.setString(3, admin.getLastName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}