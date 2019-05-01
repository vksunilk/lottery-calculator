package com.lottery.calculator.bizcore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	public Connection getConnection() throws InstantiationException, IllegalAccessException, SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC/ODBC driver.");
			e.printStackTrace();
		}
		String currentDir = System.getProperty("user.dir");
		String dbUrl = "jdbc:derby:" + currentDir + "\\DUMMY1;create=true";
		return DriverManager.getConnection(dbUrl);
	}
}