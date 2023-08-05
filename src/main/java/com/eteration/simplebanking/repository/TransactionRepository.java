package com.eteration.simplebanking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eteration.simplebanking.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	

	}


