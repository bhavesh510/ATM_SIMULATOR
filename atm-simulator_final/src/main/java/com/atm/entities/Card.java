package com.atm.entities;

import java.util.Objects;

public class Card {
	
	private String cardNo;
	private int pin;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cardNo, pin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(cardNo, other.cardNo) && pin == other.pin;
	}
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", pin=" + pin + "]";
	}
	public Card(String cardNo, int pin) {
		super();
		this.cardNo = cardNo;
		this.pin = pin;
	}
	public Card() {
		super();
	}
	
	
}
