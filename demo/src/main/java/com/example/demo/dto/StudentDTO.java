package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class StudentDTO {

	 private long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;
	    private Double totalMarks;
		private Character grade;
		private Date joiningDate;
	    private List<AddressDetailsDTO> addressDetails ;
		public long getId() {
			return id;
		}
		public Date getJoiningDate() {
			return joiningDate;
		}
		
		public void setJoiningDate(Date joiningDate) {
			this.joiningDate = joiningDate;
		}
		
		public void setId(long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Double getTotalMarks() {
			return totalMarks;
		}
		public void setTotalMarks(Double totalMarks) {
			this.totalMarks = totalMarks;
		}
		public Character getGrade() {
			return grade;
		}
		public void setGrade(Character grade) {
			this.grade = grade;
		}
		public List<AddressDetailsDTO> getAddressDetails() {
			return addressDetails;
		}
		public void setAddressDetails(List<AddressDetailsDTO> addressDetails) {
			this.addressDetails = addressDetails;
		}
		@Override
		public String toString() {
			return "StudentDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", phone=" + phone + ", totalMarks=" + totalMarks + ", grade=" + grade + ", addressDetails="
					+ addressDetails + "]";
		}





}
