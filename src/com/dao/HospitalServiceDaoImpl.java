package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabasrConnectionException;
import com.exception.PatientNumberNotFoundException;
import com.model.Appointment;
import com.util.DBUtil;

public class HospitalServiceDaoImpl implements HospitalServiceDao{


	@Override
	public Appointment getAppointmentById(List<Appointment> l,int appointmentId) throws PatientNumberNotFoundException {
		
		for(Appointment a:l)
		{
			if(a.getApp_id()== appointmentId)
			{
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(List<Appointment> l,int patientId) {
	
		List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment a : l) {
            if (a.getPatient_id() == patientId) {
                patientAppointments.add(a);
            }
        }
        return patientAppointments;
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(List<Appointment> l,int doctorId) {
		List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment a : l) {
            if (a.getPatient_id() == doctorId) {
                doctorAppointments.add(a);
            }
        }
        return doctorAppointments;
	}

	@Override
	public boolean scheduleAppointment(String appointment_date,String description) throws DatabasrConnectionException, SQLException {
		Connection conn = DBUtil.getDbConn();

		String sql = "insert into appointment(appointment_date,description) values(?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, Date.valueOf(appointment_date));
		pstmt.setString(2, description);

		pstmt.executeUpdate();

		DBUtil.DBClose();
		return true;
	}

	@Override
	public boolean updateAppointment(int aid,String field,String newVal) throws DatabasrConnectionException, SQLException {
		Connection conn = DBUtil.getDbConn();

		String sql = "update customer set "+field+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(field.equals("description"))
			pstmt.setString(1,"follow-up");
		
		pstmt.setInt(2, aid);


		pstmt.executeUpdate();

		DBUtil.DBClose();
		
		return true;
	}

	@Override
	public boolean cancelAppointment(int appointmentId) throws DatabasrConnectionException, SQLException {
		
        Connection conn = DBUtil.getDbConn();
		
		String sql = "delete from appointment where app_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, appointmentId);

		pstmt.executeUpdate();
		
		DBUtil.DBClose();
		
		return true;
	}

	@Override
	public List<Appointment> fetchAllAppointment() throws DatabasrConnectionException, SQLException {
		List<Appointment> list = new ArrayList<>();
		Connection conn = DBUtil.getDbConn();

		String sql = "select * from appointment";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int app_id = rst.getInt("app_id");
			
			int patient_id=rst.getInt("patient_id");
			
			int doctor_id=rst.getInt("doctor_id");
			
			LocalDate appointment_date = rst.getDate("appointment_date").toLocalDate();
			
			String description = rst.getString("description");
			
			Appointment a = new Appointment(app_id,patient_id,doctor_id,appointment_date,description);
			list.add(a);
			
	    }
		DBUtil.DBClose();
		return list;

   

   
}
	
}
