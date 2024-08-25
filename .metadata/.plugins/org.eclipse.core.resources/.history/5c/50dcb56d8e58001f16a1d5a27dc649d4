//package com.atm.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.atm.entities.Atm;
//import com.atm.entities.Customer;
//import com.atm.entities.Withdraw;
//import com.atm.entities.WithdrawResponse;
//import com.atm.serviceinterface.WithdrawInterface;
//
//@Service
//public class FastCashService implements WithdrawInterface {
//
//    @Autowired
//    private AtmService atmservice;
//    @Autowired
//    private CustomerService custServiceRef;
//
//    @Override
//    public WithdrawResponse accessRequets(Withdraw obj) 
//    {
//        // Retrieve ATM and customer details
//        Atm atmref = atmservice.findAtmById(1);
//        Customer cust = custServiceRef.findCustomerByCardNumber(obj.getCardNo());
//        double localWithdraw = obj.getMoney();
//
//        double[] allowedCash = {2000, 500, 200, 100};
//
//        // Check for successful withdrawal
//      
//	        for (double allowedAmount : allowedCash) 
//	        {
//	           
//	                if ((obj.getCardPin() == cust.getCardPin()) &&((allowedAmount <= atmref.getTotalCash()) && (allowedAmount <= cust.getCurrBalance())))
//	                {
//	                    double cascadeType = localWithdraw;
//	
//	                    // Update ATM cash counters (assuming methods exist)
//	                    if(allowedAmount ==  2000)
//	                    {
//	                    	//atmservice.updatec_type1CounterAtm(atmref, atmref.getC_type1(), 1);
//	                    	atmservice.updatec_type1CounterAtm(atmref,2000 , atmref.getId());
//	                    	atmservice.updateTotalCashAtm(atmref,allowedAmount,atmref.getId());
//	                        cust.setCurrBalance(cust.getCurrBalance() - 2000);
//	                        System.out.println(cust.toString());
//	                        return new WithdrawResponse(true, "Transaction successful", cust.getCurrBalance());
//	                    }
//	                    else if(allowedAmount ==  500) {
//	                    	atmservice.updatec_type2CounterAtm(atmref,500 , atmref.getId());
//	                    	atmservice.updateTotalCashAtm(atmref,allowedAmount,atmref.getId());
//	                        cust.setCurrBalance(cust.getCurrBalance() - 500);
//	                        System.out.println(cust.toString());
//	                        return new WithdrawResponse(true, "Transaction successful", cust.getCurrBalance());
//	                    }
//	                    else if(allowedAmount ==  200) {
//	                    	atmservice.updatec_type3CounterAtm(atmref,200 , atmref.getId());
//	                    	atmservice.updateTotalCashAtm(atmref,allowedAmount,atmref.getId());
//	                        cust.setCurrBalance(cust.getCurrBalance() - 200);
//	                        System.out.println(cust.toString());
//	                        return new WithdrawResponse(true, "Transaction successful", cust.getCurrBalance());
//	                    }
//	                    else if(allowedAmount ==  100) {
//	                    	atmservice.updatec_type4CounterAtm(atmref,100 , atmref.getId());
//	                    	atmservice.updateTotalCashAtm(atmref,allowedAmount,atmref.getId());
//	                        cust.setCurrBalance(cust.getCurrBalance() - 100);
//	                        System.out.println(cust.toString());
//	                        return new WithdrawResponse(true, "Transaction successful", cust.getCurrBalance());
//	                    }
//	                    else {
//	                    	 return new WithdrawResponse(false, "Transaction unsuccessful", cust.getCurrBalance());
//	                    }
//	                } 
//	          
//	        	}
////	        else{
////            	return new WithdrawResponse(false, "Pin Incorrect", cust.getCurrBalance());
////            }
////	        else {
////	              return new WithdrawResponse(false, "Insufficient funds or invalid amount", cust.getCurrBalance());
////	        }       
//        
//		return null;
//    }
//}

package com.atm.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Atm;
import com.atm.entities.Customer;
import com.atm.entities.Transaction;
import com.atm.entities.Withdraw;
import com.atm.entities.WithdrawResponse;
import com.atm.repositorie.AtmRepository;
import com.atm.repositorie.CustomerRepository;
import com.atm.serviceinterface.WithdrawInterface;

@Service
public class FastCashService implements WithdrawInterface{
@Autowired
private AtmService atmservice;

@Autowired
private CustomerService custServiceRef;

@Autowired
private TransactionService transServiceRef;

@Override
public WithdrawResponse accessRequets(Withdraw obj) {
	Atm atmref = atmservice.findAtmById(1);
	Customer cust =custServiceRef.findCustomerByCardNumber(obj.getCardNo());
	double localwithdraw =obj.getMoney() ;
    double[] allowedCash = {2000, 500, 200, 100};
    boolean b= true;
	for(double i :allowedCash) {
		if(localwithdraw == i) {
			b =false;
			break;
		}
	}
	if(b == false) {
	 if (atmref == null || cust == null) {
	        return new WithdrawResponse(false, "ATM or Customer not found.", cust.getCurrBalance());
	    }
	
	if((localwithdraw <= atmref.getTotalCash()) && (localwithdraw%100 == 0) && (localwithdraw > 0 )) {	
		int counter1 =atmref.getC_type1Counter() ;
		int counter2 =atmref.getC_type2Counter();
		int counter3 =atmref.getC_type3Counter();
		int counter4 =atmref.getC_type4Counter();
		boolean b1 = false;
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
//					b = true;**
					break;
				}
			}
			while(localwithdraw >= atmref.getC_type3() ) {
				localwithdraw -= atmref.getC_type3();
				counter3--;
				atmservice.updatec_type3CounterAtm(atmref,atmref.getC_type3Counter() ,atmref.getId());
				if(counter3 ==0) {
//					b = true;
					break;
				}
			}
			
			while(localwithdraw >= atmref.getC_type4() ) {
				localwithdraw -= atmref.getC_type4();
				counter4--;
				atmservice.updatec_type4CounterAtm(atmref,atmref.getC_type4Counter() ,atmref.getId());
				if(counter4 ==0) {
					b1 = true;
					break;
				}
			}
				
		}
		
		
		if ((b1 == false)&&(cust.getCurrBalance()>= obj.getMoney())) {
			if(cust.getCardPin() == obj.getCardPin()) {
			System.out.println("Transaction succesfull");
			cust.setCurrBalance(cust.getCurrBalance()- obj.getMoney() ) ;
			atmref.setTotalCash(atmref.getTotalCash());
			atmservice.updateTotalCashAtm(atmref,(obj.getMoney()),1);
							
			Transaction transaction = new Transaction();
			   transaction.setTranId(UUID.randomUUID().toString());
                transaction.setAtmId(atmref.getId());
                transaction.setCustomerId(cust.getCustId());
                transaction.setAmount(obj.getMoney());
                transaction.setTranType("Debit");
                transaction.setTranStatus("Success");
                transaction.setDate(LocalDateTime.now());
                transaction.setUpdatedOn(LocalDateTime.now());// Assuming LocalDateTime is used
                transaction.setUpiStatus("no_upi_use"); 
            transServiceRef.saveTransaction(transaction);
			
			return new WithdrawResponse(true, "Transaction succesfull", cust.getCurrBalance());
			}
			else {
				System.out.println("Pin or cardNo INVALID");
				return new WithdrawResponse(false, "Pin or cardNo INVALID", cust.getCurrBalance());
//				//System.out.println(localwithdraw);
//				//System.out.println(cust.getCardPin());
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
		return new WithdrawResponse(false, "Not enough cash in Atm or Not proper credential", cust.getCurrBalance());
	}
	}
	else {
		return new WithdrawResponse(false, "INVALID amount Type", cust.getCurrBalance());
	}
}
};






