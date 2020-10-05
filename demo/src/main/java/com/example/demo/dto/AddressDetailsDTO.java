package com.example.demo.dto;

import com.example.demo.model.Student;

public class AddressDetailsDTO {

    private long addressId;
    private String area;
    private String city;
    private String pincode;
   
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
	
	@Override
	public String toString() {
		return "AddressDetailsDTO [addressId=" + addressId + ", area=" + area + ", city=" + city + ", pincode="
				+ pincode + ", student="  + "]";
	}

	
}
