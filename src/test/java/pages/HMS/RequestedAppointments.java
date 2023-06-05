package pages.HMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class RequestedAppointments extends BasePage
{
	public WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Approve')]")
	private WebElement approveRequestElement;
	
	
	@FindBy(xpath = "//input[@value='Approve']")
	private WebElement approvElement;
	
	
	@FindBy(xpath = "//a[contains(.,'Delete')]")
	private WebElement deletElement;
	
	
	
	public  RequestedAppointments(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void approveRequest()
	{
		elementToBeClickable(driver, approveRequestElement);
		approveRequestElement.click();
		elementToBeClickable(driver, approvElement);
		approvElement.click();
	}
	
	public void deleteRequest() 
	{
		elementToBeClickable(driver, deletElement);
		deletElement.click();
		alertAccept(driver);
		
	}
	
}
