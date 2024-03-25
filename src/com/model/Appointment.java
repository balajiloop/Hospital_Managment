package com.model;

import java.time.LocalDate;

public class Appointment {
	private int app_id;
	private int patient_id;
	private int doctor_id;
	private LocalDate appoinment_date;
	private String description;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int app_id, int patient_id, int doctor_id, LocalDate appoinment_date, String description) {
		super();
		this.app_id = app_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appoinment_date = appoinment_date;
		this.description = description;
	}
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public LocalDate getAppoinment_date() {
		return appoinment_date;
	}
	public void setAppoinment_date(LocalDate appoinment_date) {
		this.appoinment_date = appoinment_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Appointment [app_id=" + app_id + ", patient_id=" + patient_id + ", doctor_id=" + doctor_id
				+ ", appoinment_date=" + appoinment_date + ", description=" + description + "]";
	}
	
	

}
