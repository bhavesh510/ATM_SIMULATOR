package com.atm.serviceinterface;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.atm.entities.Card;
import com.atm.entities.Customer;
import com.atm.entities.Transfer;

@Service
public interface CustomerServiceInterface {
	
    public void insertCustomerDetails(Customer CustomerDetail);
    public void insertArrayOfCustomerDetails(List<Customer> CustomerDetail);
    public List<Customer> CustomerDetails();
    public Customer findCustomerById(int id);
    public Customer findCustomerByName(String name);
    public void deleteCustomerById(int id);
    public void updateCustomer(Customer updateCustomer);
    public void updateArrayCustomer(List<Customer> listCustomerDetails);
    public Customer checkCardNoAndPin(Card details);
    public void accTransfer(Transfer details);
    public void upiTransfer(Transfer details);
    public Customer findCustomerByCardNumber(String cardNo);
    public double balance(int custId);
}
