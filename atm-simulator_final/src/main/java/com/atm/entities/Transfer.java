package com.atm.entities;

import java.util.Objects;

public class Transfer {
	
	private String selfAccount;
	private String anotherAccount;
	private String selfUPI;
	private String anotherUPI;
	private double money;
	
	
	public String getSelfUPI() {
		return selfUPI;
	}
	public void setSelfUPI(String selfUPI) {
		this.selfUPI = selfUPI;
	}
	public String getAnotherUPI() {
		return anotherUPI;
	}
	public void setAnotherUPI(String anotherUPI) {
		this.anotherUPI = anotherUPI;
	}
	public String getSelfAccount() {
		return selfAccount;
	}
	public void setSelfAccount(String selfAccount) {
		this.selfAccount = selfAccount;
	}
	public String getAnotherAccount() {
		return anotherAccount;
	}
	public void setAnotherAccount(String anotherAccount) {
		this.anotherAccount = anotherAccount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anotherAccount, anotherUPI, money, selfAccount, selfUPI);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		return Objects.equals(anotherAccount, other.anotherAccount) && Objects.equals(anotherUPI, other.anotherUPI)
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money)
				&& Objects.equals(selfAccount, other.selfAccount) && Objects.equals(selfUPI, other.selfUPI);
	}
	@Override
	public String toString() {
		return "Transfer [selfAccount=" + selfAccount + ", anotherAccount=" + anotherAccount + ", selfUPI=" + selfUPI
				+ ", anotherUPI=" + anotherUPI + ", money=" + money + "]";
	}
	
	public Transfer(String selfAccount, String anotherAccount, String selfUPI, String anotherUPI, double money) {
		super();
		this.selfAccount = selfAccount;
		this.anotherAccount = anotherAccount;
		this.selfUPI = selfUPI;
		this.anotherUPI = anotherUPI;
		this.money = money;
	}
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
