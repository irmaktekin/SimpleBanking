package com.eteration.simplebanking.model;

import javax.persistence.Entity;

// This class is a place holder you can change the complete implementation

@Entity
public class DepositTransaction extends Transaction  {

	String accountNumber;
	
	public DepositTransaction(String accountNumber, double amount) {
		super(amount, 'D',accountNumber);
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
