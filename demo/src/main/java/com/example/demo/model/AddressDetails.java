package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "address_details")
public class AddressDetails {

	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private long addressId;

	@Column(name = "area")
	private String area;

	@Column(name = "city")
	private String city;

	@Column(name = "pincode")
	private String pincode;

	@ManyToOne
	@JoinColumn(name = "student_id")
	@NotNull
	private Student student;

	public AddressDetails() {
	}
	
	public AddressDetails(String city) {
		this.city=city;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

}