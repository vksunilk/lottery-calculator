package test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckConnection {

	private static final String CUSTOMER_TABLE = "CREATE TABLE CUSTOMERS "
			+ "(CUSTOMER_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY," + "CUSTOMERS_UUID VARCHAR(36) NOT NULL,"
			+ "CUSTOMER_NAME VARCHAR(150),GROUP_UUID VARCHAR(36) NOT NULL," + "PHONE_NUMBER VARCHAR(50),"
			+ "EMAIL_ADDRESS VARCHAR(50)," + "PLACE VARCHAR(100)," + "UPDATED_DATE_TIME TIMESTAMP,"
			+ "PRIMARY KEY (CUSTOMER_ID)," + "UNIQUE (CUSTOMERS_UUID))";

	private static final String CUSTOMER_HEADER_TABLE = "CREATE TABLE CUSTOMER_TRANSACTION_HEAD_TRN"
			+ "(CUSTOMER_TRANSACTION_HEAD_TRN_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
			+ "CUSTOMER_UUID VARCHAR(36) NOT NULL," + "RECORD_DATE TIMESTAMP," + "DAILY_BALANCE DECIMAL(30),"
			+ "WEEKLY_BALANCE DECIMAL(30)," + "OUTSTANDING_BALANCE DECIMAL(30)," + "CURRENT_BALANCE DECIMAL(30),"
			+ "BALANCE_PAID DECIMAL(30),commission DECIMAL(30)," + "TOTAL_BALANCE DECIMAL(30),"
			+ "LAST_UPDATE_DATE_TIME TIMESTAMP," + "PRIMARY KEY (CUSTOMER_TRANSACTION_HEAD_TRN_ID),"
			+ "UNIQUE (CUSTOMER_UUID))";

	private static final String CUSTOMER_DETAIL_TABLE = "CREATE TABLE CUSTOMER_TRANSACTION_DETAIL_TRN"
			+ "(CUSTOMER_TRANSACTION_DETAIL_TRN_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,"
			+ "CUSTOMER_UUID VARCHAR(36) NOT NULL," + "RECORD_DATE TIMESTAMP," + "DAILY_BALANCE DECIMAL(30),"
			+ "WEEKLY_BALANCE DECIMAL(30)," + "OUTSTANDING_BALANCE DECIMAL(30)," + "CURRENT_BALANCE DECIMAL(30),"
			+ "BALANCE_PAID DECIMAL(30),commission DECIMAL(30)," + "TOTAL_BALANCE DECIMAL(30),"
			+ "LAST_UPDATE_DATE_TIME TIMESTAMP,"
			+ "PRIMARY KEY (CUSTOMER_TRANSACTION_DETAIL_TRN_ID),UNIQUE (CUSTOMER_UUID))";
	private static Connection conn;

	public static void main(String[] args) throws SQLException {
		String currentDir = System.getProperty("user.dir");
		String dbUrl = "jdbc:derby:" + currentDir + "\\DUMMY1;create=true";
		conn = DriverManager.getConnection(dbUrl);
		Statement stmt = conn.createStatement();
		try {
//			stmt.executeUpdate("create table users (username varchar(36)")
			stmt.executeUpdate(CUSTOMER_TABLE);
			stmt.executeUpdate(CUSTOMER_HEADER_TABLE);
			stmt.executeUpdate(CUSTOMER_DETAIL_TABLE);
//			stmt.executeUpdate("alter table CUSTOMER_TRANSACTION_HEAD_TRN add column commission DECIMAL(30)");
//			stmt.executeUpdate("alter table CUSTOMER_TRANSACTION_DETAIL_TRN add column commission DECIMAL(30)");
			stmt.executeUpdate(
					"CREATE TABLE GROUPS (GROUP_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,GROUP_UUID VARCHAR(36), "
							+ "GROUP_NAME VARCHAR(50), UPDATED_DATE_TIME TIMESTAMP," + "PRIMARY KEY (GROUP_ID),"
							+ "UNIQUE (GROUP_UUID))");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// insert 2 rows
		// stmt.executeUpdate("insert into users values (3,'tom')");
		// stmt.executeUpdate("insert into users values (4,'peter')");

		// query
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

		// print out query result
		// while (rs.next()) {
		// System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
		// }
	}
}
