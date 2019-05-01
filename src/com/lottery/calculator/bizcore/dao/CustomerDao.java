package com.lottery.calculator.bizcore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lottery.calculator.bizcore.database.DatabaseManager;
import com.lottery.calculator.bizcore.entity.CustomerEntity;

public class CustomerDao {
	private static final String SELECT_FROM_CUSTOMERS = "Select * from Customers";

	private static final String INSERT_QUERY = "Insert into CUSTOMERS "
			+ "(CUSTOMERS_UUID,CUSTOMER_NAME,GROUP_UUID,PHONE_NUMBER,EMAIL_ADDRESS,PLACE,UPDATED_DATE_TIME) "
			+ "VALUES(?,?,?,?,?,?,CURRENT_TIMESTAMP)";

	private DatabaseManager db;

	public CustomerDao() {
		db = new DatabaseManager();
	}

	public void addCustomers(String customerName, String contactNumber, String emailAddres, String place,
			UUID groupUuid) throws SQLException, InstantiationException, IllegalAccessException {
		Connection conn = db.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, UUID.randomUUID().toString());
		preparedStatement.setString(2, customerName);
		preparedStatement.setString(3, groupUuid.toString());
		preparedStatement.setString(4, contactNumber);
		preparedStatement.setString(5, emailAddres);
		preparedStatement.setString(6, place);
		preparedStatement.executeUpdate();
		conn.commit();
		conn.close();

	}

	public ResultSet getCustomers() throws SQLException, InstantiationException, IllegalAccessException {
		Connection conn = db.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(SELECT_FROM_CUSTOMERS);
		conn.close();
		return resultSet;
	}

	public List<CustomerEntity> getCustomersAsEntity()
			throws SQLException, InstantiationException, IllegalAccessException {
		Connection conn = db.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery(SELECT_FROM_CUSTOMERS);
		List<CustomerEntity> customerEntityList = new ArrayList<>();
		while (resultset.next()) {
			CustomerEntity entity = new CustomerEntity();
			entity.setGroupUUID(UUID.fromString(resultset.getString("GROUP_UUID")));
			entity.setCustomerUUID(UUID.fromString(resultset.getString("CUSTOMERS_UUID")));
			entity.setCustomerName(resultset.getString("CUSTOMER_NAME"));
			entity.setPhoneNumber(resultset.getString("PHONE_NUMBER"));
			entity.setEmailAddress(resultset.getString("EMAIL_ADDRESS"));
			entity.setPlace(resultset.getString("PLACE"));
			entity.setUpdatedDateTime(resultset.getTimestamp("UPDATED_DATE_TIME"));
			customerEntityList.add(entity);
		}
		conn.close();
		return customerEntityList;

	}
}
