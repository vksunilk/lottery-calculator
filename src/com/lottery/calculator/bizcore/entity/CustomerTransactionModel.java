package com.lottery.calculator.bizcore.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomerTransactionModel extends AbstractTableModel {

	private final List<CustomerTransactionEntity> customerTransactionEntityList;

	private final String[] columnNames = new String[] { "Id", "Name", "Daily", "Weekly", "Outstanding", "Paid",
			"Total Amount" };
	private final Class[] columnClass = new Class[] { Long.class, String.class, BigDecimal.class, BigDecimal.class,
			BigDecimal.class, BigDecimal.class, BigDecimal.class };

	public CustomerTransactionModel(List<CustomerTransactionEntity> customerTransactionEntityList) {
		this.customerTransactionEntityList = customerTransactionEntityList;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return customerTransactionEntityList.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		CustomerTransactionEntity row = customerTransactionEntityList.get(rowIndex);
		if (0 == columnIndex) {
			return row.getId();
		} else if (1 == columnIndex) {
			return row.getName();
		} else if (2 == columnIndex) {
			return row.getDailyAmount();
		} else if (3 == columnIndex) {
			return row.getWeeklyAmount();
		} else if (4 == columnIndex) {
			return row.getOutstandingBalance();
		} else if (5 == columnIndex) {
			return row.getPaidAmount();
		} else if (6 == columnIndex) {
			return row.getTotalAmount();
		}
		return null;
	}
}
