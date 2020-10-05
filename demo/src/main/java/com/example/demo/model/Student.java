package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	private Double totalMarks;
	private Character grade;

	@Temporal(TemporalType.DATE)

	private Date joiningDate;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<AddressDetails> addressDetails;

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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

	

	public Student() {
	}


	public Student(Long id, Date joiningDate, String firstName, Double totalMarks, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.totalMarks = totalMarks;
	this.id = id;
	this.joiningDate = joiningDate;

	
}
	


	public long getId() {
		return id;
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

	public List getAddressDetails() {
		return addressDetails;
	}

	public Student(AddressDetails addressDetails) {
		super();

	}

	public void setAddressDetails(List addressDetails) {
		this.addressDetails = addressDetails;
	}
}