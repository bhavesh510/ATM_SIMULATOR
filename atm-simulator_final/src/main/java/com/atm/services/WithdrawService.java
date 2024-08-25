    package com.atm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Atm;
import com.atm.entities.Customer;
import com.atm.entities.Withdraw;
import com.atm.entities.WithdrawResponse;
import com.atm.repositorie.AtmRepository;
import com.atm.repositorie.CustomerRepository;
import com.atm.serviceinterface.WithdrawInterface;

@Service
public class WithdrawService implements WithdrawInterface{
	@Autowired
	private AtmService atmservice;

	@Autowired
	private CustomerService custServiceRef;

	@Override
	public WithdrawResponse accessRequets(Withdraw obj) {
		Atm atmref = atmservice.findAtmById(1);
		Customer cust =custServiceRef.findCustomerByCardNumber(obj.getCardNo());
		double localwithdraw =obj.getMoney() ;
		
		 if (atmref == null || cust == null) {
		        return new WithdrawResponse(false, "ATM or Customer not found.", cust.getCurrBalance());
		    }
		
		if((localwithdraw <= atmref.getTotalCash()) && (localwithdraw%100 == 0) && (localwithdraw > 0 )) {	
			int counter1 =atmref.getC_type1Counter() ;
			int counter2 =atmref.getC_type2Counter();
			int counter3 =atmref.getC_type3Counter();
			int counter4 =atmref.getC_type4Counter();
			boolean b = false;
			while(localwithdraw > 0) {	//9000
				while(localwithdraw >= atmref.getC_type1() ) {
					if(counter1 > 0)
					{
						localwithdraw -= atmref.getC_type1();
						counter1--;
						atmservice.updatec_type1CounterAtm(atmref,atmref.getC_type1Counter() ,atmref.getId());
						if(counter1 ==0) {
	//						b = true;
							break;
						}
					}
					else {
						break;
					}
				}
				while(localwithdraw >= atmref.getC_type2() ) {
					localwithdraw -= atmref.getC_type2();
				    counter2--;
					atmservice.updatec_type2CounterAtm(atmref,atmref.getC_type2Counter() ,atmref.getId());
					if(counter2 ==0) {
//						b = true;**
						break;
					}
				}
				while(localwithdraw >= atmref.getC_type3() ) {
					localwithdraw -= atmref.getC_type3();
					counter3--;
					atmservice.updatec_type3CounterAtm(atmref,atmref.getC_type3Counter() ,atmref.getId());
					if(counter3 ==0) {
//						b = true;
						break;
					}
				}
				
				while(localwithdraw >= atmref.getC_type4() ) {
					localwithdraw -= atmref.getC_type4();
					counter4--;
					atmservice.updatec_type4CounterAtm(atmref,atmref.getC_type4Counter() ,atmref.getId());
					if(counter4 ==0) {
						b = true;
						break;
					}
				}
					
			}
			
			
			if ((b == false)&&(cust.getCurrBalance()>= obj.getMoney())) {
				if(cust.getCardPin() == obj.getCardPin()) {
				System.out.println("Transaction succesfull");
				cust.setCurrBalance(cust.getCurrBalance()- obj.getMoney() ) ;
				atmref.setTotalCash(atmref.getTotalCash());
				atmservice.updateTotalCashAtm(atmref,(obj.getMoney()),1);
				
				
				return new WithdrawResponse(true, "Transaction succesfull", cust.getCurrBalance());
				}
				else {
					System.out.println("Pin or cardNo INVALID");
					return new WithdrawResponse(false, "Pin or cardNo INVALID", cust.getCurrBalance());
//					//System.out.println(localwithdraw);
//					//System.out.println(cust.getCardPin());
				}
			}
			else{
				System.out.println("Transaction Unsuccesfull");
				return new WithdrawResponse(false, "Transaction Unsuccesfull", cust.getCurrBalance());
			}
		}
		else {
			System.out.println(atmref.toString());
			System.out.println("Not enough cash in Atm or Not proper credential");
			return new WithdrawResponse(false, "Not enough cash in Atm or Not proper credential or invalid entry", cust.getCurrBalance());
		}
	}
};



    
