package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Atm;
import com.atm.entities.Withdraw;
import com.atm.serviceinterface.AtmServiceInterface;

@RestController
public class AtmController 
{
	@Autowired
	private AtmServiceInterface atmServiceRef;
	
	@GetMapping("/Getatm")
	public List<Atm> getAllAtm()
	{
		return atmServiceRef.atmDetails();
	}
	
	@PostMapping("/Insertatm/details")
	public void insertDetails(@RequestBody Atm details)
	{
		atmServiceRef.insertAtmDetails(details);
		System.out.println("Inserted Successful" + details);
	}
	
	@PostMapping("/Insertatm/atmDetails")
	public void insertArrayOfAtmDetails(@RequestBody List<Atm> atmDetails)
	{
		atmServiceRef.insertArrayOfAtmDetails(atmDetails);
		System.out.println("Inserted records successfully.");
	}
	
	@GetMapping("/Getatm/{id}")
	public Atm findAtmById(@PathVariable int id)
	{
		return atmServiceRef.findAtmById(id);
	}
	
	@GetMapping("/Getatm/{name}")
	public Atm findAtmByName(@PathVariable String name)
	{
		return atmServiceRef.findAtmByName(name);
	}
	
	@PostMapping("/Deleteatm/{id}")
	public void deleteAtmById(@PathVariable int id)
	{
		atmServiceRef.deleteAtmById(id);
	}
	
	@PostMapping("/Updateatm/atmDetails")
	public void updateAtm(@RequestBody Atm atmDetail)
	{
		atmServiceRef.updateAtm(atmDetail);
	}
	
	@PostMapping("/Updatearrayatm/listAtmDetails")
	public void updateArrayAtm(@RequestBody List<Atm> listAtmDetail)
	{
		atmServiceRef.updateArrayAtm(listAtmDetail);
	}
	
//	@PostMapping("/withdraw")
//	public void withdrawAmount(@RequestBody Withdraw details)
//	{
//		atmServiceRef.withdrawAmount(details);
//	}
	
}
