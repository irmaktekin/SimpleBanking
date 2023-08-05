package com.eteration.simplebanking.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.dto.AccountDto;
import com.eteration.simplebanking.model.Amount;
import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;

@RequestMapping("/v1/account")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BankAccount> getAccountById(@PathVariable(value = "id") Long accountId) throws Exception{
		return ResponseEntity.ok(accountService.findById(accountId));
	}
	
	@PostMapping
	public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount) {
		return new ResponseEntity<BankAccount>(accountService.save(bankAccount), HttpStatus.CREATED);
	}
	
	@PostMapping("/credit/{id}")
	@NotNull
    public ResponseEntity<AccountDto> addCredit(@PathVariable(value = "id") String accountNumber, @RequestBody Amount amount) throws Exception {
		return ResponseEntity.ok(accountService.saveCredit(new DepositTransaction(accountNumber, amount.getAmount())));
    }
	
	@PostMapping("/debit/{id}")
    public ResponseEntity<AccountDto> decreaseCredit(@PathVariable(value = "id") String accountNumber, @RequestBody Amount amount) throws Exception {		
	    return ResponseEntity.ok(accountService.saveCredit(new WithdrawalTransaction( amount.getAmount(), accountNumber)));
    }
	
}