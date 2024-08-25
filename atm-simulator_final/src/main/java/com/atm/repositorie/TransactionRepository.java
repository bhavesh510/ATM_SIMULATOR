package com.atm.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

    

