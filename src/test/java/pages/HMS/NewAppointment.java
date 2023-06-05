package pages.HMS;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class NewAppointment extends BasePage
{
	public WebDriver driver;
	
	@FindBy(xpath = "//button[contains(.,'Add Appointment')]")
	private WebElement addappointmentElement;
	
	
	@FindBy(xpath = "//button[contains(.,'Apply For Appointment')]")
	private WebElement applyforappontmenElement;
	
	
	@FindBy(xpath = "//input[@placeholder='date here']")
	private WebElement dateElement;
	
	
	@FindBy(css = "table[class=' table-condensed'] th[class='datepicker-switch']")
	private WebElement calenderElement;
	

	@FindBy(xpath = "//table[@class=' table-condensed']//th[@class='next'][.='»']")
	private WebElement nextmonthElement;
	
	@FindBy(xpath = "//td[.='25']")
	private WebElement datendayElement;
	
	
	
	@FindBy(xpath = "//input[@placeholder='time here']")
	private WebElement timeElement;
	
	
	@FindBy(xpath = "//a[@data-action='incrementHour']//i[@class='icon-chevron-up']")
	private WebElement nextHour;
	
	@FindBy(xpath = "//input[@class='bootstrap-timepicker-hour']")
	private WebElement timeselectElement;
	
	
	
	@FindBy(xpath = "//span[.='Select Doctor']")
	private WebElement selectdoctorElement;
	
	
	@FindBy(xpath = "//span[@class='select2-chosen']")
	private WebElement selectpatientElement;
	
	
	@FindBy(xpath = "//div[@class='select2-search']//input[@type='text']")
	private WebElement searchdoctornamElement;
	
	
	@FindBy(xpath = "//div[@class='select2-search']//input[@type='text']")
	private WebElement searchpatientElement;
	
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitappointmentElement;
	
	
	
	
	
	
	
	
	public  NewAppointment(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addappointment()
	{
		visibilityofElement(driver, addappointmentElement);
		addappointmentElement.click();
	}
	
	public void applyforappointment() 
	{
		elementToBeClickable(driver, applyforappontmenElement);
		//javascriptClick(driver, applyforappontmenElement);
		applyforappontmenElement.click();
	}
	
	public void selectdate() 
	{
		visibilityofElement(driver, dateElement);
		dateElement.click();
		while (!(calenderElement.getText().equalsIgnoreCase("December 2026"))) 
		{
			javascriptClick(driver, nextmonthElement);
		}
		
		visibilityofElement(driver, datendayElement);
		javascriptClick(driver, datendayElement);
	}
	
	public void selecttime() throws AWTException, InterruptedException 
	{
		visibilityofElement(driver, timeElement);
		timeElement.click();
		SelectAllAndDelete();
		timeElement.sendKeys("10:05");
		
	}
	
	
	public void selectDoctor() throws AWTException, InterruptedException 
	{
		selectdoctorElement.click();
		searchdoctornamElement.sendKeys("Batra");
		robotEnter();
		
		submitappointmentElement.click();
		
	}
	
	public void selectPatient() throws AWTException, InterruptedException {
		selectpatientElement.click();
		Thread.sleep(500);
		visibilityofElement(driver, searchpatientElement);
		searchpatientElement.sendKeys("nagato");
		robotEnter();
		submitappointmentElement.click();
	}
	
	
}
