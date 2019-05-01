package com.lottery.calculator.biz.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lottery.calculator.bizcore.dao.CustomerDao;
import com.lottery.calculator.bizcore.entity.CustomerEntity;
import com.lottery.calculator.bizcore.entity.GroupEntity;

public class CustomerService {
	CustomerDao dao;

	public CustomerService() throws InstantiationException, IllegalAccessException, SQLException {
		dao = new CustomerDao();
	}

	public void addCustomers(String customerName, String contactNumber, String emailAddres, String place,
			GroupEntity groupEntity) throws SQLException, InstantiationException, IllegalAccessException {
		dao.addCustomers(customerName, contactNumber, emailAddres, place, groupEntity.getGroupUUID());
	}

	public ResultSet getCustomer() throws SQLException, InstantiationException, IllegalAccessException {
		return dao.getCustomers();
	}

	public List<CustomerEntity> getCustomersAsEntity()
			throws SQLException, InstantiationException, IllegalAccessException {
		return dao.getCustomersAsEntity();
	}
}
