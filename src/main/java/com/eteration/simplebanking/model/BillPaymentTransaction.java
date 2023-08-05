package com.eteration.simplebanking.model;

public class BillPaymentTransaction extends WithdrawalTransaction{
	private String accountNumber;

	public BillPaymentTransaction(double amount, String payee) {
		super(amount,'D');
		this.accountNumber=payee;
		// TODO Auto-generated constructor stub
	}

}
