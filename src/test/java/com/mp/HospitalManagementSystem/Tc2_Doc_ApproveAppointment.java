package com.mp.HospitalManagementSystem;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.BaseTest;
import pages.HMS.DoctorLoginPage;
import pages.HMS.HmsDoctorHomePage;
import pages.HMS.RequestedAppointments;

public class Tc2_Doc_ApproveAppointment extends BaseTest
{
	@Test
	public void DoctorLogin() throws IOException 
	{
		DoctorLoginPage dc=new DoctorLoginPage(driver);
		dc.Login();
	}
	
	
	
	@Test(dependsOnMethods = "DoctorLogin")
	public void ApproveAppointmentRequest() 
	{
		HmsDoctorHomePage hmsDoctorHomePage=new HmsDoctorHomePage(driver);
		hmsDoctorHomePage.appointment();
		hmsDoctorHomePage.requestedappointments();
		
		RequestedAppointments requestedAppointments=new RequestedAppointments(driver);
		requestedAppointments.approveRequest();
		
		hmsDoctorHomePage.logout();
		
	}
}
