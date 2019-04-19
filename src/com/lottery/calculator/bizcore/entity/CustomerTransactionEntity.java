package com.lottery.calculator.bizcore.entity;

import java.math.BigDecimal;

public class CustomerTransactionEntity {

	private long id;
	private String name;
	private BigDecimal dailyAmount = BigDecimal.ZERO;
	private BigDecimal weeklyAmount = BigDecimal.ZERO;
	private BigDecimal outstandingBalance = BigDecimal.ZERO;
	private BigDecimal paidAmount = BigDecimal.ZERO;
	private BigDecimal totalAmount = BigDecimal.ZERO;

	public CustomerTransactionEntity(int id, String name, BigDecimal dailyAmount, BigDecimal weeklyAmount,
			BigDecimal outstandingBalance, BigDecimal paidAmount, BigDecimal totalAmount) {
		super();
		this.id = id;
		this.name = name;
		this.dailyAmount = dailyAmount;
		this.weeklyAmount = weeklyAmount;
		this.outstandingBalance = outstandingBalance;
		this.paidAmount = paidAmount;
		this.totalAmount = totalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(BigDecimal dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	public BigDecimal getWeeklyAmount() {
		return weeklyAmount;
	}

	public void setWeeklyAmount(BigDecimal weeklyAmount) {
		this.weeklyAmount = weeklyAmount;
	}

	public BigDecimal getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(BigDecimal outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
