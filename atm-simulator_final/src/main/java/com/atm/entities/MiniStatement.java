package com.atm.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MiniStatement {
	private LocalDate transactionDate;
	private String transactionType;
	private String transactionStatus;
	private LocalTime transactionTime;
	private double transactionAmount;
	
	//constructor using fields
	public MiniStatement(LocalDate transactionDate, String transactionType, String transactionStatus,
	LocalTime transactionTime, double transactionAmount) {
		super();
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.transactionTime = transactionTime;
		this.transactionAmount = transactionAmount;
	}
	
	//getter and setter
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public LocalTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalTime localTime) {
		this.transactionTime = localTime;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	//constructor using super class
	public MiniStatement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
