package com.eteration.simplebanking.dto;

import java.util.List;

import com.eteration.simplebanking.model.Transaction;

public class AccountDto {
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getOwner() {
		return ownerName;
	}
	public void setOwner(String owner) {
		this.ownerName = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	private String accountNumber;
	private String ownerName;
	private double balance;
	private List <Transaction> transactions;

}
