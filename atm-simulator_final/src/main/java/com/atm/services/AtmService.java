package com.atm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.atm.entities.Atm;
import com.atm.entities.Customer;
import com.atm.entities.Withdraw;
import com.atm.repositorie.AtmRepository;
import com.atm.repositorie.CustomerRepository;
import com.atm.serviceinterface.AtmServiceInterface;

@Service
public class AtmService implements AtmServiceInterface
{
	@Autowired
	private AtmRepository atmRepoRef;
	@Autowired
	private CustomerRepository custRepo;
	//insert one Atm details
	public void insertAtmDetails(Atm atmDetail)
	{
		atmRepoRef.save(atmDetail);
	}
	
	//insert Array of Atm details
	public void insertArrayOfAtmDetails(List<Atm> atmDetail)
	{
		atmRepoRef.saveAll(atmDetail);
	}
	
	//Show All atm
	public List<Atm> atmDetails()
	{
		return atmRepoRef.findAll();
	}
		
	//show atm by id
	public Atm findAtmById(int id)
	{
		List<Atm> ls = atmRepoRef.findAll();
		Atm foundAtm = null;
		for(Atm a : ls)
		{
			if(id==a.getId())
			{
				foundAtm = a;
				break;
			}
		}
		return foundAtm;
	}
	
	//show atm by name
	public Atm findAtmByName(String name)
	{
		List<Atm> ls = atmRepoRef.findAll();
		Atm foundAtm = null;
		for(Atm a : ls)
		{
			if(name==a.getName())
			{
				foundAtm = a;
				break;
			}
		}
		return foundAtm;
	}
	
	public void deleteAtmById(int id)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(a.getId() == id)
			{
				atmRepoRef.delete(a);
			}
		}
	}
	
	public void updateAtm(Atm updateAtm)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	
	public void updateArrayAtm(List<Atm> listAtmDetails)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
		for(Atm b : listAtmDetails)
		{
			if(a.getId() == b.getId())
			{
				atmRepoRef.save(b);
			}
		}
	}
	}
	
	public void updateTotalCashAtm(Atm updateAtm,Double amount ,int id) {
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				Double updatedTotalCash =updateAtm.getTotalCash() - amount;
				updateAtm.setTotalCash(updatedTotalCash);
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	public void updatec_type1CounterAtm(Atm updateAtm,int c_type1Counter ,int id) {
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				int updatedc_type1Counter =updateAtm.getC_type1Counter()-1;
				updateAtm.setC_type1Counter(updatedc_type1Counter);
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	public void updatec_type2CounterAtm(Atm updateAtm,int c_type2Counter ,int id) {
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				int updatedc_type2Counter =updateAtm.getC_type2Counter()-1;
				updateAtm.setC_type2Counter(updatedc_type2Counter);
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	public void updatec_type3CounterAtm(Atm updateAtm,int c_type3Counter ,int id) {
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				int updatedc_type3Counter =updateAtm.getC_type3Counter()-1;
				updateAtm.setC_type3Counter(updatedc_type3Counter);
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	public void updatec_type4CounterAtm(Atm updateAtm,int c_type4Counter ,int id) {
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				int updatedc_type4Counter =updateAtm.getC_type4Counter()-1;
				updateAtm.setC_type4Counter(updatedc_type4Counter);
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	
}
