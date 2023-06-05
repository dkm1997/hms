package generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class screenshot extends BaseTest implements ITestListener 
{
	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);

		String methodNameString=result.getName();

		Date date=Calendar.getInstance().getTime();
		String todayString=date.toString().replace(":", "_");

		File destiFile=new File("./failedscreenshot/" + methodNameString + todayString+".png");
		//System.out.println("status of the testcase is: "+result.getStatus());

		if (result.getStatus()==2)
		{
			System.out.println("Test is failed");
		}


		try {
			FileHandler.copy(srcFile,destiFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}


	}



	public void onTestSkipped(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String methodNameString=result.getName();

		Date date=Calendar.getInstance().getTime();
		String todayString=date.toString().replace(":", "_");
		

		File destiFile=new File("./skippedscreenshot/" + methodNameString + todayString+".png");
		try {
			FileHandler.copy(srcFile,destiFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}


	}
	public void onTestSuccess(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String methodNameString=result.getName();
		
		Date date=Calendar.getInstance().getTime();
		String todayString=date.toString().replace(":", "_");
		
		
		File destiFile=new File("./passedscreenshot/" + methodNameString + todayString+".png");
		try {
			FileHandler.copy(srcFile,destiFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
