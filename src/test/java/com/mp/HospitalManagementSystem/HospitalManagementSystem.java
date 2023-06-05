package com.mp.HospitalManagementSystem;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generics.BaseTest;
import pages.HMS.DoctorLoginPage;
import pages.HMS.HmsDoctorHomePage;
import pages.HMS.HmsPatientHomePage;
import pages.HMS.NewAppointment;
import pages.HMS.PatientLoginPage;
import pages.HMS.RequestedAppointments;

public class HospitalManagementSystem extends BaseTest
{
	
	@Test
	public void HMSPatientLogin() throws IOException 
	{
		PatientLoginPage patientLoginPage=new PatientLoginPage(driver);
		patientLoginPage.Login();
	}
	
	@Test(dependsOnMethods ="HMSPatientLogin")
	public void TakingNewAppointment() throws AWTException, InterruptedException 
	{
		HmsPatientHomePage hmsPatientHomePage=new HmsPatientHomePage(driver);
		hmsPatientHomePage.appointment();
		hmsPatientHomePage.appointmentlist();
		
		NewAppointment newAppointment=new NewAppointment(driver);
		newAppointment.applyforappointment();
		newAppointment.selectdate();
		newAppointment.selecttime();
		newAppointment.selectDoctor();
		
	}
	@Test(dependsOnMethods = "TakingNewAppointment")
	public void PatientLogout() 
	{
		HmsPatientHomePage hmsPatientHomePage=new HmsPatientHomePage(driver);
		hmsPatientHomePage.logout();
	}
	
	@Test(dependsOnMethods = "PatientLogout")
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
