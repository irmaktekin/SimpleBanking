package com.eteration.simplebanking.dto;

import java.util.Date;

public class TransactionDto {
	private double amount;
	private Date transactionDate;
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	} 

}
