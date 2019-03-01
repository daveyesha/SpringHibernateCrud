package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="address")
public class Address {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Student sObj;
	@Column
	private String street;
	@Column
	private String landmark;
	@Column
	private int pincode;
	public Address(){
		
	}
	public Address(String street,String landmark,int pincode2,Student sObj){
		super();
		this.street=street;
		this.landmark=landmark;
		this.pincode=pincode2;
		this.sObj=sObj;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Student getsObj() {
		return sObj;
	}
	public void setsObj(Student sObj) {
		this.sObj = sObj;
	}
}
