package com.atm.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="atm")
public class Atm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //Autogenerate ID
	private int id;
	@Column
	private String location;
//	@Column
//	private int bankId;            //foreign key of Bank
	@Column
	private String city;
	@Column
	private int pinCode;
	@Column
	private double totalCash;
	@Column
	private int c_type1Counter;    //number of 100 notes
	@Column
	private int c_type2Counter;
	@Column
	private int c_type3Counter;
	@Column
	private int c_type4Counter;
	@Column
	private int c_type1;           //this will work as 100 rs note
	@Column
	private int c_type2;
	@Column
	private int c_type3;
	@Column
	private int c_type4;
	@Column
	private String name;
	double total = 0;
	public Atm(int id, String location, String city, int pinCode, double totalCash, int c_type1Counter,
			int c_type2Counter, int c_type3Counter, int c_type4Counter, int c_type1, int c_type2, int c_type3,
			int c_type4, String name) {
		super();
		this.id = id;
		this.location = location;
		this.city = city;
		this.pinCode = pinCode;
		this.totalCash = totalCash;
		this.c_type1Counter = c_type1Counter;
		this.c_type2Counter = c_type2Counter;
		this.c_type3Counter = c_type3Counter;
		this.c_type4Counter = c_type4Counter;
		this.c_type1 = c_type1;
		this.c_type2 = c_type2;
		this.c_type3 = c_type3;
		this.c_type4 = c_type4;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public Atm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(c_type1, c_type1Counter, c_type2, c_type2Counter, c_type3, c_type3Counter, c_type4,
				c_type4Counter, city, id, location, name, pinCode, totalCash);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atm other = (Atm) obj;
		return c_type1 == other.c_type1 && c_type1Counter == other.c_type1Counter && c_type2 == other.c_type2
				&& c_type2Counter == other.c_type2Counter && c_type3 == other.c_type3
				&& c_type3Counter == other.c_type3Counter && c_type4 == other.c_type4
				&& c_type4Counter == other.c_type4Counter && Objects.equals(city, other.city) && id == other.id
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& pinCode == other.pinCode
				&& Double.doubleToLongBits(totalCash) == Double.doubleToLongBits(other.totalCash);
	}
	@Override
	public String toString() {
		return "Atm [id=" + id + ", location=" + location + ", city=" + city + ", pinCode=" + pinCode + ", totalCash="
				+ totalCash + ", c_type1Counter=" + c_type1Counter + ", c_type2Counter=" + c_type2Counter
				+ ", c_type3Counter=" + c_type3Counter + ", c_type4Counter=" + c_type4Counter + ", c_type1=" + c_type1
				+ ", c_type2=" + c_type2 + ", c_type3=" + c_type3 + ", c_type4=" + c_type4 + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
//	public int getBankId() {
//		return bankId;
//	}
//	public void setBankId(int bankId) {
//		this.bankId = bankId;
//	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public double getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(double totalCash) {
		this.totalCash = getC_type1Counter() * getC_type1() + getC_type2Counter() * getC_type2() + getC_type3Counter() * getC_type3() + getC_type4Counter() * getC_type4();
	}
	public int getC_type1Counter() {
		return c_type1Counter;
	}
	public void setC_type1Counter(int c_type1Counter) {
		this.c_type1Counter = c_type1Counter;
	}
	public int getC_type2Counter() {
		return c_type2Counter;
	}
	public void setC_type2Counter(int c_type2Counter) {
		this.c_type2Counter = c_type2Counter;
	}
	public int getC_type3Counter() {
		return c_type3Counter;
	}
	public void setC_type3Counter(int c_type3Counter) {
		this.c_type3Counter = c_type3Counter;
	}
	public int getC_type4Counter() {
		return c_type4Counter;
	}
	public void setC_type4Counter(int c_type4Counter) {
		this.c_type4Counter = c_type4Counter;
	}
	public int getC_type1() {
		return c_type1;
	}
	public void setC_type1(int c_type1) {
		this.c_type1 = c_type1;
	}
	public int getC_type2() {
		return c_type2;
	}
	public void setC_type2(int c_type2) {
		this.c_type2 = c_type2;
	}
	public int getC_type3() {
		return c_type3;
	}
	public void setC_type3(int c_type3) {
		this.c_type3 = c_type3;
	}
	public int getC_type4() {
		return c_type4;
	}
	public void setC_type4(int c_type4) {
		this.c_type4 = c_type4;
	}
	
	
}
