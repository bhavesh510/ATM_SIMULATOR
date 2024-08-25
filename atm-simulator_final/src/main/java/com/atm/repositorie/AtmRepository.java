package com.atm.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.entities.Atm;
@Repository
public interface AtmRepository extends JpaRepository<Atm, Integer>{
	
}
