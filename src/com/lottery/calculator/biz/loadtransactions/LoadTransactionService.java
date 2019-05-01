package com.lottery.calculator.biz.loadtransactions;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.lottery.calculator.bizcore.entity.CustomerTransactionEntity;
import com.lottery.calculator.bizcore.entity.CustomerTransactionModel;

public class LoadTransactionService {

	public CustomerTransactionModel getTableModel(String customer, Date fromDate, Date toDate) {
		BigDecimal dummy = new BigDecimal(1000);
		CustomerTransactionEntity CustomerTransactionEntity = new CustomerTransactionEntity("", "aaaa", dummy, dummy,
				dummy, dummy, dummy);
		return new CustomerTransactionModel(Arrays.asList(CustomerTransactionEntity));
	}

}
