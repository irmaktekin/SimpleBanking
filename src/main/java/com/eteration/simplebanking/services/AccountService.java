package com.eteration.simplebanking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.eteration.simplebanking.dto.AccountDto;
import com.eteration.simplebanking.dto.TransactionDto;
import com.eteration.simplebanking.exception.AccountNotFoundException;
import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;
	List <Transaction> transacList = new ArrayList();

	public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	public List<BankAccount> findAll() {
		return accountRepository.findAll();
	}

	public BankAccount save(BankAccount bankAccount) {
		return accountRepository.save(bankAccount);

	}

	public BankAccount findById(Long accountId) throws Exception {
		return accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("No data!"));

	}
	
		
	@Transactional
	public AccountDto saveCredit(Transaction transaction) throws Exception {
		
		BankAccount account = accountRepository.findByAccountNumberIs(transaction.getAccountNumber()).orElseThrow(()-> new RuntimeException("cannot find"));
		
		if(transaction instanceof DepositTransaction){
			Double amount = transaction.getAmount();
			account.setBalance(account.getBalance()+amount);
		}
		else if(transaction instanceof WithdrawalTransaction) {
			Double amount = transaction.getAmount();
			
			if(account.getBalance()-amount<0) {
				throw new InsufficientBalanceException("Your current balance is not enough!");
				
			}
			else {
				account.setBalance(account.getBalance()-amount);
				
			}
		}
					
			
		accountRepository.save(account);
		transactionRepository.save(transaction);
		return convertToDto(transaction);
		
	}

	
	private AccountDto convertToDto(Transaction transaction) {
		
		ModelMapper modelMapper = new ModelMapper();
		BankAccount account = accountRepository.findByAccountNumberIs(transaction.getAccountNumber()).orElseThrow(()-> new RuntimeException("cannot find"));
		TransactionDto transactionDto = modelMapper.map(transaction,TransactionDto.class);
		System.out.println(transactionDto);
		transactionDto.setAmount(transaction.getAmount());
		System.out.println(transaction.getTransactionDate());
		//transactionDto.setTransactionDate(transaction.getTransactionDate());
		AccountDto accountDto = modelMapper.map(account,AccountDto.class);
		transacList.add(transaction);
		accountDto.setTransactions(transacList);
		return accountDto;
	
	}

	
	public Object findByAccountNumber(String accountNumber) {		
		return accountRepository.findAccountByAccountNumber(accountNumber);
	}

	
	
	
	
	
	
	
	

}
