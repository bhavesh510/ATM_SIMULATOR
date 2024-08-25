package com.atm.serviceinterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.entities.Atm;
import com.atm.entities.Withdraw;

@Service
public interface AtmServiceInterface {

    public void insertAtmDetails(Atm atmDetail);
    public void insertArrayOfAtmDetails(List<Atm> atmDetail);
    public List<Atm> atmDetails();
    public Atm findAtmById(int id);
    public Atm findAtmByName(String name);
    public void deleteAtmById(int id);
    public void updateAtm(Atm updateAtm);
    public void updateArrayAtm(List<Atm> listAtmDetails);
//    public void withdrawAmount(Withdraw details);
}
