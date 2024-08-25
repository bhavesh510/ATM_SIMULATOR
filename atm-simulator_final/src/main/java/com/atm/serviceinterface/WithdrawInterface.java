package com.atm.serviceinterface;

import com.atm.entities.Withdraw;
import com.atm.entities.WithdrawResponse;


public interface WithdrawInterface {
	 WithdrawResponse accessRequets(Withdraw obj);
	 //public void acessResponse(Transfer details);
	 //public boolean verifyPin(int pin ,String cardNo) ;
}
