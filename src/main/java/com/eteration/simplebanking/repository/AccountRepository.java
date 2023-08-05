package com.eteration.simplebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.Transaction;



@Repository
public interface AccountRepository extends JpaRepository<BankAccount,Long>{
	@Query(value = "select b from BankAccount b where b.accountNumber = :accountNumber")
	BankAccount findAccountByAccountNumber(@Param("accountNumber") String accountNumber);
	
	Optional<BankAccount> findByAccountNumberIs(String accountNumber);
}
