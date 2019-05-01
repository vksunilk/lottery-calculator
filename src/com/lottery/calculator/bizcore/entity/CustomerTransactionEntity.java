package com.lottery.calculator.bizcore.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerTransactionEntity {

	private String customerId;
	private String name;
	private BigDecimal dailyAmount = BigDecimal.ZERO;
	private BigDecimal weeklyAmount = BigDecimal.ZERO;
	private BigDecimal outstandingBalance = BigDecimal.ZERO;
	private BigDecimal paidAmount = BigDecimal.ZERO;
	private BigDecimal totalAmount = BigDecimal.ZERO;

}
