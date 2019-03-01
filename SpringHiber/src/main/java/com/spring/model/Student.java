package com.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;
@Entity
	@Table(name="student")
	public class Student {
		@Id
		@Column
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		@Column
		private String sFirstName;
		@Column
		private String sLastName;
		@Column
		private double sEnroll;
		@Column
		private String sAdd;
		@Column
		private String sEmail;
		@Column
		private String sPassword;
		
		@OneToMany(mappedBy ="sObj",cascade = CascadeType.ALL)
		private Set<Address> addAddress;
		
		
		public Student(){}
		public Student(String fname,String lname,int roll,String sAdd,String email,String pass){
			super();
			this.sFirstName=fname;
			this.sLastName=lname;
			this.sEnroll=roll;
			this.sAdd=sAdd;
			this.sEmail=email;
			this.sPassword=pass;
		}
		public void setsAdd(String sAdd) {
			this.sAdd = sAdd;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getsFirstName() {
			return sFirstName;
		}
		public void setsFirstName(String sFirstName) {
			this.sFirstName = sFirstName;
		}
		public String getsLastName() {
			return sLastName;
		}
		public void setsLastName(String sLastName) {
			this.sLastName = sLastName;
		}
		public double getsEnroll() {
			return sEnroll;
		}
		public void setsEnroll(double sEnroll) {
			this.sEnroll = sEnroll;
		}
		public String getsAdd() {
			return sAdd;
		}
		public void setsCity(String sCity) {
			this.sAdd = sCity;
		}
		public String getsEmail() {
			return sEmail;
		}
		public void setsEmail(String sEmail) {
			this.sEmail = sEmail;
		}
		public String getsPassword() {
			return sPassword;
		}
		public void setsPassword(String sPassword) {
			this.sPassword = sPassword;
		}
		public Set<Address> getAddAddress() {
			return addAddress;
		}
		public void setAddAddress(Set<Address> addAddress) {
			this.addAddress = addAddress;
		}
		
}
