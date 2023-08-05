package com.eteration.simplebanking.model;

import javax.persistence.Entity;

@Entity
// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction {
	String accountNumber;

	public WithdrawalTransaction(double amount, String accountNumber) {
		super(amount,'C',accountNumber);
		this.accountNumber = accountNumber;
	}
	
	public WithdrawalTransaction(double amount, char type) {
		super(amount,type);
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
}


