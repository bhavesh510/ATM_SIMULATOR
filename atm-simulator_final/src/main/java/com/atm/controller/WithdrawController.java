package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Atm;
import com.atm.entities.Withdraw;
import com.atm.entities.WithdrawResponse;
import com.atm.services.WithdrawService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class WithdrawController {
	
	
	@Autowired
	WithdrawService withdreawref;
	 @PostMapping("/withdraw")
	    public WithdrawResponse withdrawVerify(@RequestBody Withdraw obj) {
		 return withdreawref.accessRequets(obj);
	}
}
