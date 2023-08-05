package com.eteration.simplebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")

public class BankAccount {
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="owner_name",length=128,nullable=false)
	private String ownerName;
	
	@Column(name="account_number",length=128,nullable=false)
	private String accountNumber;
	
	@Column(name="balance",nullable=false)
	private double balance;
	
	
	public BankAccount() {
		super();
	}
	
	
	public BankAccount(String ownerName, String accountNumber) {
		super();
		this.ownerName = ownerName;
		this.accountNumber = accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public Long getId() {
		return id;		
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", ownerName=" + ownerName + ", accountNumber="
				+ accountNumber + ", balance=" + balance + "]";
	}

	
	
	
}
