package com.atm.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Card;
import com.atm.entities.Customer;
import com.atm.entities.Transfer;
import com.atm.repositorie.CustomerRepository;
import com.atm.serviceinterface.CustomerServiceInterface;

@Service

public class CustomerService implements CustomerServiceInterface{
	
	@Autowired
	private CustomerRepository custRepoRef;
	
	//insert one Customer details
	@Override
	public void insertCustomerDetails(Customer CustomerDetail) {
		// TODO Auto-generated method stub
		custRepoRef.save(CustomerDetail);
	}
	//insert Array of Customer details
	public void insertArrayOfCustomerDetails(List<Customer> CustomerDetail) {
		// TODO Auto-generated method stub
		custRepoRef.saveAll(CustomerDetail);
	}
	//Show All Customer
	public List<Customer> CustomerDetails() {
		// TODO Auto-generated method stub
		return custRepoRef.findAll();
	}
	
		
	//show Customer by id
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		List<Customer> ls = custRepoRef.findAll();
		Customer foundCustomer = null;
		for(Customer a : ls)
		{
			if(id==a.getCustId())
			{
				foundCustomer = a;
				break;
			}
		}
		return foundCustomer;
	}

	@Override
	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		List<Customer> ls = custRepoRef.findAll();
		Customer foundCustomer = null;
		for(Customer a : ls)
		{
			if(name==a.getCustName())
			{
				foundCustomer = a;
				break;
			}
		}
		return foundCustomer;
	}

	
	public Customer checkCardNoAndPin(Card details)
	{
		List<Customer> custList = custRepoRef.findAll();
		Customer found = null;
		for(Customer cust : custList)
		{
			if((cust!= null) && (cust.getCardNo().equals(details.getCardNo())) && (details.getPin() == cust.getCardPin()))
			{
				found = cust;
			}
		}
		return found;
	}

	
	@Override
	public void deleteCustomerById(int id) {
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
			if(a.getCustId() == id)
			{
				custRepoRef.delete(a);
			}
		}
		
		
	}
	@Override
	public Customer findCustomerByCardNumber(String cardNo) {
		// TODO Auto-generated method stub
		List<Customer> ls = custRepoRef.findAll();
		Customer foundCustomer = null;
		for(Customer a : ls)
		{
			if(cardNo.equals(a.getCardNo()))
			{
				foundCustomer = a;
				break;
			}
		}
		return foundCustomer;
	}

	@Override
	public void updateCustomer(Customer updateCustomer) {
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
			if(updateCustomer.getCustId() == a.getCustId())
			{
				custRepoRef.save(updateCustomer);
				
			}
		}
	}

	@Override
	public void updateArrayCustomer(List<Customer> listCustomerDetails) {
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
			for(Customer b : listCustomerDetails)
			{
				if(a.getCustId() == b.getCustId())
				{
					custRepoRef.save(b);
				}
			}
		}
		
	}
	
	public String accTransfer(Transfer details) {
	    String message = "";
	    List<Customer> ls = custRepoRef.findAll();

	    boolean userFound = false;
	    boolean transfereeFound = false;

	    for (Customer user : ls) {
	        if (user.getAccNo().equals(details.getSelfAccount())) {
	            userFound = true;

	            if (user.getCurrBalance() > details.getMoney()) {
	                for (Customer transferee : ls) {
	                    if (transferee.getAccNo().equals(details.getAnotherAccount())) {
	                        transfereeFound = true;

	                        double balance = details.getMoney() + transferee.getCurrBalance();
	                        transferee.setCurrBalance(balance);
	                        double minus = user.getCurrBalance() - details.getMoney();
	                        user.setCurrBalance(minus);
	                        custRepoRef.save(user);
	                        custRepoRef.save(transferee);
	                        
	                        return "Transaction Successful";
	                    }
	                }
	                if (!transfereeFound) {
	                    return "Invalid Account Number";
	                }
	            } else {
	                return "Insufficient Balance";
	            }
	        }
	    }

	    if (!userFound) {
	        return "Invalid Self Account Number";
	    }

	    return message;
	}

	public String upiTransfer(Transfer details) {
	    List<Customer> customers = custRepoRef.findAll();
	    Customer sender = null;
	    Customer receiver = null;

	    // Find sender and receiver based on UPI IDs
	    for (Customer customer : customers) {
	        if (customer.getUpiId().equals(details.getSelfUPI())) {
	            sender = customer;
	        } else if (customer.getUpiId().equals(details.getAnotherUPI())) {
	            receiver = customer;
	        }
	        
	        // Break loop early if both are found
	        if (sender != null && receiver != null) {
	            break;
	        }
	    }

	    // Validate sender
	    if (sender == null) {
	        return "Invalid Sender UPI ID";
	    }

	    // Validate receiver
	    if (receiver == null) {
	        return "Invalid Receiver UPI ID";
	    }

	    // Check if sender has sufficient balance
	    if (sender.getCurrBalance() < details.getMoney()) {
	        return "Insufficient Balance";
	    }

	    // Perform the transaction
	    double newReceiverBalance = receiver.getCurrBalance() + details.getMoney();
	    double newSenderBalance = sender.getCurrBalance() - details.getMoney();

	    receiver.setCurrBalance(newReceiverBalance);
	    sender.setCurrBalance(newSenderBalance);

	    // Save the updated customer data
	    custRepoRef.save(sender);
	    custRepoRef.save(receiver);

	    return "Transaction Successful";
	}

	public double balance(int custId) {
		Customer ref=findCustomerById(custId);
		return ref.getCurrBalance();
				
	}


}
