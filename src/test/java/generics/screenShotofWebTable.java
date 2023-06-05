package generics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShotofWebTable 
{
	
	public void screenshoofwebtable() throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		WebElement table=driver.findElement(By.id("table1"));
		File srcFile=table.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(srcFile,new File("./failedscreenshot/webtable.png"));
		
		
	}
	
}
