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
	
	public void accTransfer(Transfer details)
	{
		List<Customer> ls = custRepoRef.findAll();
		for(Customer user : ls)
		{
			if(user.getAccNo().equals(details.getSelfAccount()))
			{
				for(Customer transferee : ls)
				{
					if(transferee.getAccNo().equals(details.getAnotherAccount()))
					{
						double balance = details.getMoney() + transferee.getCurrBalance();
						transferee.setCurrBalance(balance);
						double minus = user.getCurrBalance() - details.getMoney();
						user.setCurrBalance(minus);
						custRepoRef.save(user);
						custRepoRef.save(transferee);
					}
				}
			}
		}
	}
	
	public void upiTransfer(Transfer details)
	{
		List<Customer> ls = custRepoRef.findAll();
		for(Customer user : ls)
		{
			if(user.getUpiId().equals(details.getSelfUPI()))
			{
				for(Customer transferee : ls)
				{
					if(transferee.getUpiId().equals(details.getAnotherUPI()))
					{
						double balance = details.getMoney() + transferee.getCurrBalance();
						transferee.setCurrBalance(balance);
						double minus = user.getCurrBalance() - details.getMoney();
						user.setCurrBalance(minus);
						custRepoRef.save(user);
						custRepoRef.save(transferee);
					}
				}
			}
		}
	}
	public double balance(int custId) {
		Customer ref=findCustomerById(custId);
		return ref.getCurrBalance();
				
	}


}
