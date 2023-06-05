package generics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class screenShotOfwebEelement
{
	public static void takeElementScreenshot(WebElement element , String fileString) throws IOException
	{
		TakesScreenshot ts=element;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
	
	FileHandler.copy(srcFile,new File("./failedscreenshot/"+fileString+".png"));
		
	}
}
