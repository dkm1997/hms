package pages.HMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class HmsDoctorHomePage extends BasePage
{
	public WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement logoutElement;
	
	@FindBy(xpath = "//li[4]//a[1]")
	private WebElement patientElement;
	
	@FindBy(xpath = "//label[contains(.,'Search:')]")
	private WebElement patientNameSearchElement;
	
	
	@FindBy(xpath = "//span[.='Appointment']")
	private WebElement appointmentElement;
	
	
	@FindBy(xpath = "//span[.='Appointment List']")
	private WebElement appointmentListElement;
	
	
	
	
	@FindBy(xpath = "//span[.='Requested Appointments']")
	private WebElement requestedappointments;
	
	
	
	
	
	
	public HmsDoctorHomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void patient()
	{
		visibilityofElement(driver, patientElement);
		javascriptClick(driver, patientElement);
	}
	
	public void searchpatientname(String name)
	{
		visibilityofElement(driver, patientElement);
		patientElement.sendKeys(name);;
	}
	
	
	public void appointment()
	{
		visibilityofElement(driver, appointmentElement);
		appointmentElement.click();
	}
	
	
	
	public void appointmentlist() 
	{
		visibilityofElement(driver, appointmentListElement);
		appointmentListElement.click();
		
	}
	
	
	
	
	
	
	public void requestedappointments() 
	{
		visibilityofElement(driver, requestedappointments);
		requestedappointments.click();
	}
	
	public void logout() 
	{
		logoutElement.click();
	}
	
}
