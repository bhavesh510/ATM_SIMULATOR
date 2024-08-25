package com.atm.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
