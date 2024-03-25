package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Appointment;
import com.dao.*;
import com.exception.DatabasrConnectionException;
import com.exception.PatientNumberNotFoundException;
public class AppointmentController {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		 
		 HospitalServiceDao hsd=new HospitalServiceDaoImpl();
		 while(true)
		 {

	     System.out.println("****Hospital Managment****");
	     System.out.println("press 1 for getAppointmentById");
	     System.out.println("press 2 for getAppointmentForPatient");
	     System.out.println("press 3 for getAppointmentForDoctor");
	     System.out.println("press 4 for schedule Appointment");
	     System.out.println("press 5 for update Appointment");
	     System.out.println("press 6 for cancel Appointment");
	     System.out.println("press 0 to exit");
	     int input=sc.nextInt();
	     if(input==0)
	     {
	    	 System.out.println("Thank you");
	    	 break;
	     }
	            
	  
	        	
	        	switch(input)
	        	{
	        	
	        	case 1:
	        	try
	        	{
	        	List<Appointment> l=hsd.fetchAllAppointment();
	        	System.out.println(l);
	        	System.out.println("Enter Appointment id:");
	        	int id=sc.nextInt();
	            Appointment a = hsd.getAppointmentById(l,id);
	            System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s", "app_id",
						"Patient_id", "doctor_id", "appointment_date", "description"));
				System.out.println(String.format("%-15d%-15d%-15d%-15s%-15s", a.getApp_id(),
						a.getPatient_id(), a.getDoctor_id(),a.getAppoinment_date().toString(),a.getDescription()));
	        	}
	        	catch(PatientNumberNotFoundException |DatabasrConnectionException|SQLException e)
	        	{
	        		System.out.println(e.getMessage());
	        	
	        	}
				break;

	        	case 2:
	        		try
	        		{
	        		List<Appointment> l=hsd.fetchAllAppointment();
					System.out.println("Enter Patient id:");
					int patient_id=sc.nextInt();
					List<Appointment> pal = hsd.getAppointmentsForPatient(l,patient_id);
					System.out.println("Appointments for patient: " + pal);
	        		}
	        		catch(DatabasrConnectionException|SQLException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}
	   
	        	break;

	        	case 3:
	        		try
	        		{
	        		List<Appointment> l1=hsd.fetchAllAppointment();
					System.out.println("Enter Doctor id:");
					int doctor_id=sc.nextInt();
					List<Appointment> dal = hsd.getAppointmentsForDoctor(l1,doctor_id);
					System.out.println("Appointments for doctor: " + dal);
					}
	        		catch(DatabasrConnectionException|SQLException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}

	            
	        	case 4:
	        		
	        		try
	        		{
					System.out.println("Enter Registration Date:");
					String appointment_date=sc.next();
					System.out.println("Enter description:");
					String description=sc.next();
					boolean scheduled = hsd.scheduleAppointment(appointment_date,description);
					if(scheduled)
					{
						System.out.println("Appointment scheduled  Successfull!!");
					}
					else
					{
						System.out.println("Appointment scheduled  failed!!");
					}
	        		}
	        		catch( DatabasrConnectionException|SQLException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}
	        	break;
	
	        	case 5:
	        		try
	        		{
	        		List<Appointment> l=hsd.fetchAllAppointment();
					System.out.println("Enter appointment Id to be updated:");
					int aid = sc.nextInt();
					System.out.println();
					Appointment a1 = hsd.getAppointmentById(l,aid);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s", "app_id",
									"Patient_id", "doctor_id", "appointment_date", "description"));
					System.out.println(String.format("%-15d%-15d%-15d%-15s%-15s", a1.getApp_id(),
									a1.getPatient_id(), a1.getDoctor_id(),a1.getAppoinment_date().toString(),a1.getDescription()));			
					String field="description";
					System.out.println("Enter the new description:");
					String newVal=sc.nextLine();
					boolean updated = hsd.updateAppointment(aid,field,newVal);
					if(updated)
					{
					System.out.println("Description updated Successfully");
					}
					else
					{
						System.out.println("Description update failed");
					}
	        		}
	        		catch(PatientNumberNotFoundException|DatabasrConnectionException|SQLException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}
	        	break;
	                

	        	case 6:
	        		try
	        		{
					System.out.println("Enter Appointment Id to be deleted");
					int aid1 = sc.nextInt();
					hsd.cancelAppointment(aid1);
					System.out.println("appointment cancelled successfully!!");
	        		}
	        		catch(DatabasrConnectionException|SQLException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}
	        	break;
	        	
	        	}
	        	
	        }
					 
	            
	       } 
}


