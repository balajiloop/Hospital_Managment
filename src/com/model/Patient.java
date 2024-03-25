package com.model;

import java.time.LocalDate;

public class Patient {
	private int patient_id;
	private String first_name;
	private String last_name;
	private LocalDate dob;
	private String gender;
	private String phone_number;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(int patient_id, String first_name, String last_name, LocalDate dob, String gender,
			String phone_number) {
		super();
		this.patient_id = patient_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.phone_number = phone_number;
	}


	public int getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", dob=" + dob + ", gender=" + gender + ", phone_number=" + phone_number + "]";
	}
	
	

}
