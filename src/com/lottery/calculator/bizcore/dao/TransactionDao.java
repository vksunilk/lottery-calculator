package com.lottery.calculator.bizcore.dao;

import com.lottery.calculator.bizcore.database.DatabaseManager;

public class TransactionDao {

	private DatabaseManager db;

	public TransactionDao() {
		db = new DatabaseManager();
	}

	public boolean insertTransactions() {
		return true;
	}
}
