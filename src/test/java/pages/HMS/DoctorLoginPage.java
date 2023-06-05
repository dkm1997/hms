package pages.HMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.AutoConstant;
import generics.BasePage;
import generics.ExcelLibrary;

public class DoctorLoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement email;
	
	
	@FindBy(id= "password")
	private WebElement password;
	
	
	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;
	
	
	public DoctorLoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Login() throws IOException 
	{
		visibilityofElement(driver, email);
		email.sendKeys(ExcelLibrary.getcellvalue(sheet_name_DoctorLoginInfo, 0, 0));
		password.sendKeys(ExcelLibrary.getcellvalue(sheet_name_DoctorLoginInfo, 1, 0));

		javascriptClick(driver, loginButton);
	}
	
	
	
	
	
}
