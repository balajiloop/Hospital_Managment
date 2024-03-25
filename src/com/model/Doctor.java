package com.model;

public class Doctor {
	private int doctor_id;
	private String first_name;
	private String last_name;
	private String specialization;
	private String phone_number;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int doctor_id, String first_name, String last_name, String specialization, String phone_number) {
		super();
		this.doctor_id = doctor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.specialization = specialization;
		this.phone_number = phone_number;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", specialization=" + specialization + ", phone_number=" + phone_number + "]";
	}
	
	
	

}
