package com.hrm.framework.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBHelper {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/awa_orangehrm";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	@SuppressWarnings("finally")
	public Map<String, String> readLoginTable() {
		Map<String, String> loginData = new HashMap<String, String>();
		Connection conn = null;
		Statement stmt = null;

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			stmt = conn.createStatement();
			String sql = "SELECT username, password FROM login";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				loginData.put("username", username);
				loginData.put("password", password);
				System.out.println("Username: " + username + ", Password: " + password);
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			return loginData;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
			return loginData;
		}
	}
}
