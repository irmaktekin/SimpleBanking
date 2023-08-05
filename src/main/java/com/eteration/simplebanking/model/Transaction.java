package com.eteration.simplebanking.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="transaction", indexes= {@Index(name="accountid_index", columnList="account_number",unique=true)}) //index ekle(account idye)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public abstract class Transaction {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false, updatable=false)
	private Long id;
	
	@Column(name="type",nullable=false)
	private char type;
	
	
	@CreationTimestamp
	@Column(name="local_date")
	private Date transactionDate;
	
	@Column(name="amount",nullable=false)
	private double amount;
	
	
	@Column(name="account_number", nullable=false)
	private String accountNumber;

	
	@ManyToOne
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    private BankAccount account;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String accountNumber, double amount, char type) {
		this.amount=amount;		
		this.type=type;
		
	}
	public Transaction(BankAccount bankAccount) {
		this.account=bankAccount;
	}

	public Transaction(double amount, char type) {
		this.amount=amount;		
		this.type=type;
	}
	
	public Transaction(double amount, char type, String accountNumber) {
		this.amount=amount;		
		this.type=type;
	}
	
	public Transaction(Date transactionDate, double amount,BankAccount bankAccount) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.account=bankAccount;
	}
	
	public Long getId() {
		return id;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public BankAccount getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	
	
}
