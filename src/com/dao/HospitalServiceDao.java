package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.DatabasrConnectionException;
import com.exception.PatientNumberNotFoundException;
import com.model.Appointment;

public interface HospitalServiceDao {
	
	public Appointment getAppointmentById(List<Appointment> l,int appointmentId) throws PatientNumberNotFoundException;
	
    public List<Appointment> getAppointmentsForPatient(List<Appointment> l,int patientId);
    
    public List<Appointment> getAppointmentsForDoctor(List<Appointment> l,int doctorId);
    
    public boolean scheduleAppointment(String appointment_date,String description) throws DatabasrConnectionException, SQLException;
    
    public boolean updateAppointment(int aid,String field,String newVal) throws DatabasrConnectionException, SQLException;
    
    public boolean cancelAppointment(int appointmentId) throws DatabasrConnectionException, SQLException;

	public List<Appointment> fetchAllAppointment() throws DatabasrConnectionException, SQLException;

}
