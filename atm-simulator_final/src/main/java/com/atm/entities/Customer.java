package com.atm.entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@Column
	private int bankId;
	@Column
	private String accNo;
	@Column
	private String custName;
	@Column
	private String upiId;
	@Column
	private double currBalance;
	@Column
	private int cardPin;
	@Column
	private Date insertedOn;
	@Column
	private Date updatedOn;
	@Column
	private int mobileNo;
	@Column
	private String cardNo;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public double getCurrBalance() {
		return currBalance;
	}
	public void setCurrBalance(double currBalance) {
		this.currBalance = currBalance;
	}
	
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getInsertedOn() {
		return insertedOn;
	}
	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accNo, bankId, cardNo, cardPin, currBalance, custId, custName, insertedOn, mobileNo,
				updatedOn, upiId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accNo, other.accNo) && bankId == other.bankId && Objects.equals(cardNo, other.cardNo)
				&& cardPin == other.cardPin
				&& Double.doubleToLongBits(currBalance) == Double.doubleToLongBits(other.currBalance)
				&& custId == other.custId && Objects.equals(custName, other.custName)
				&& Objects.equals(insertedOn, other.insertedOn) && mobileNo == other.mobileNo
				&& Objects.equals(updatedOn, other.updatedOn) && Objects.equals(upiId, other.upiId);
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", bankId=" + bankId + ", accNo=" + accNo + ", custName=" + custName
				+ ", upiId=" + upiId + ", currBalance=" + currBalance + ", cardPin=" + cardPin + ", insertedOn="
				+ insertedOn + ", updatedOn=" + updatedOn + ", mobileNo=" + mobileNo + ", cardNo=" + cardNo + "]";
	}
	
	public Customer(int custId, int bankId, String accNo, String custName, String upiId, double currBalance,
			int cardPin, Date insertedOn, Date updatedOn, int mobileNo, String cardNo) {
		super();
		this.custId = custId;
		this.bankId = bankId;
		this.accNo = accNo;
		this.custName = custName;
		this.upiId = upiId;
		this.currBalance = currBalance;
		this.cardPin = cardPin;
		this.insertedOn = insertedOn;
		this.updatedOn = updatedOn;
		this.mobileNo = mobileNo;
		this.cardNo = cardNo;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
