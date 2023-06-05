package com.mp.HospitalManagementSystem;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generics.BaseTest;
import pages.HMS.DoctorLoginPage;
import pages.HMS.HmsDoctorHomePage;
import pages.HMS.NewAppointment;

public class Tc1_Doc_ProvideAppointment_to_patient extends BaseTest
{
	@Test
	public void DoctorLogin() throws IOException 
	{
		DoctorLoginPage dPage=new DoctorLoginPage(driver);
		dPage.Login();
	}
	@Test(dependsOnMethods = "DoctorLogin")
	public void AddAppointment() throws AWTException, InterruptedException 
	{
		HmsDoctorHomePage hmsDoctorHomePage=new HmsDoctorHomePage(driver);
		hmsDoctorHomePage.appointment();
		hmsDoctorHomePage.appointmentlist();
		NewAppointment newAppointment=new NewAppointment(driver);
		newAppointment.addappointment();
		newAppointment.selectdate();
		newAppointment.selecttime();
		newAppointment.selectPatient();
	}
	@Test(dependsOnMethods = "AddAppointment")
	public void DoctorLogout() throws IOException 
	{
		HmsDoctorHomePage hmsDoctorHomePage=new HmsDoctorHomePage(driver);
		hmsDoctorHomePage.logout();
	}
	
}
