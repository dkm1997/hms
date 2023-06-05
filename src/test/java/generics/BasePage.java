package generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	//WebDriver Interface
	public void validateTitle(WebDriver driver , String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle , "both titles not matching");
		Reporter.log("both titles are matching" , true);
	}
	
	
	
	/***********************************************/
	//Select Class
	public void selectByIndex(WebElement element , Integer index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);

	}

	public void selectByValue(WebElement element , String text)
	{
		Select select=new Select(element);
		select.selectByValue(text);
		
	}
	
	
	public void selectByVisibleText(WebElement element , String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	public void getListOfOptions(WebDriver driver , WebElement element ) 
	{
		Select select=new Select(element);

		List<WebElement> alloptions=select.getOptions();
				
	}
	
	
	public void deselectByIndex(WebElement element , Integer index)
	{
		Select select=new Select(element);
		select.deselectByIndex(index);

	}

	public void deselectByValue(WebElement element , String text)
	{
		Select select=new Select(element);
		select.deselectByValue(text);
		
	}
	
	
	public void deselectByVisibleText(WebElement element , String text)
	{
	    Select select=new Select(element);
		select.deselectByVisibleText(text);
		
	}
	
	public void deselectAll(WebElement element) 
	{
	    Select select=new Select(element);
	    select.deselectAll();
	}
	
	
	
	
	
	

	/************************************/

	//Actions Class
	public void movetoElement(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void clickByAction(WebDriver driver )
	{
		Actions actions=new Actions(driver);
		actions.click().perform();
	}

	public void ClickOnElement(WebDriver driver , WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.click(target).perform();
	}


	public void rightClick(WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}


	public void rightClickOnElement(WebDriver driver , WebElement target) 
	{
		Actions actions=new Actions(driver);
		actions.contextClick(target).perform();
	}

	public void doubleClick(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick().perform();
	}



	public void doubleClickOnTarget(WebDriver driver , WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(target).perform();
	}

	public void dragAndDrop(WebDriver driver , WebElement sourc , WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(sourc, target).perform();

	}

	public void dragAndDropBy(WebDriver driver , WebElement source , int xOffset , int yOffset) 
	{
		Actions actions=new Actions(driver);
		actions.dragAndDropBy(source, xOffset, yOffset).perform();

	}

	public void moveToTargetElement(WebDriver driver , WebElement source , int xOffset , int yOffset) 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(source, xOffset, yOffset).perform();

	}

	public void openTheElementInNewTab(WebDriver driver , WebElement element) 
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();
		/*keyDown will press the key and keyUp will release the key*/
	}

	public void ScrollToElement(WebDriver driver , WebElement target) 
	{
		Actions actions=new Actions(driver);
		actions.scrollToElement(target).perform();
	}

	public void SliderControl(WebDriver driver , WebElement slider , int xOffset , int yOffset ) 
	{
		Actions actions=new Actions(driver);
		actions.dragAndDropBy(slider, xOffset, yOffset).perform();
	}

	public void clickAndHOld(WebDriver driver , WebElement target)
	{

		Actions actions=new Actions(driver);
		actions.clickAndHold(target).perform();
	}

	public void release(WebDriver driver , WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.release(target);
	}

	public void pauseAction(WebDriver driver , java.time.Duration duration)
	{
		Actions actions=new Actions(driver);
		actions.pause(duration);
	}

	
	
    /***********************************************/
	//Robot Class
	public void robotEnter() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickOnAddressBar() throws AWTException, InterruptedException 
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_L);
		Thread.sleep(500);
	}
	
	
	public void SelectAllAndDelete() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_DELETE);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_DELETE);
		Thread.sleep(1500);
		
	}

	public void copy() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(1500);
	}
	public void cut() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);
		Thread.sleep(1500);
	}
	
	public void paste() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1500);
	}
	
	
	public void tab() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
	}
	
	
	public void leftArrow() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_LEFT);
		Thread.sleep(1500);
	}
	
	
	public void rightArrow() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1500);
	}
	
	
	public void upArrow() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(1500);
	}
	
	
	
	public void downArrow() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1500);
	}
	
	
	
	public void pageUp() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1500);
	}
	
	
	public void pageDown() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1500);
	}
	
	public void openNewTab() throws AWTException, InterruptedException 
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		Thread.sleep(1500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1500);
	}
	
	
	
	
	
	/**************************************************/
	//WebDriverWait Class
	public void titleis(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void alertIsPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void visibilityofElement(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void visibilityofElementByLocator(WebDriver driver , By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	public void elementToBeClickable(WebDriver driver , WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementToBeClickableByLocator(WebDriver driver , By locator) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void visibilityofAllElementsByLocator(WebDriver driver , By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	public void visibilityOfAllElements(WebDriver driver , WebElement elements) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void invisibilityOfAllElements(WebDriver driver , WebElement elements) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	
	
	public void frameToBeAvailableAndSwitchToItByLocator(WebDriver driver , By locator )
	{

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
		
	public void frameToBeAvailableAndSwitchToItByWebelemt(WebDriver driver , WebElement element )
	{

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	
	public void frameToBeAvailableAndSwitchToItByIntFrameLocator(WebDriver driver , Integer index)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	
	public void frameToBeAvailableAndSwitchToItByStringFrameLocator(WebDriver driver  , String string)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(string));
	}
	
	
	
	
	/*****************************************************/
	
	//JavascriptExecutor Interface
	public void javascriptClick(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void javascriptEnter(WebDriver driver , String value , WebElement element)  
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value, element);   // "arguments[0].value='qwertyasdfg'"
	}	
	
	public void createAlertPopUp(WebDriver driver , String alertcode) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(alertcode);  //  "alert('type ur message')"   
		                              //  "prompt('type ur message?')"
                                      //  "confirm('type ur message?')"
	}

	
	public void currentURL(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return document.URL"));
	}
	
	public void refreshPage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		
	}
	
	
	
	
	/********************************************/
	//Alert Interface
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();

	}

	public void getTextOfTheAlert(WebDriver driver) 
	{
		driver.switchTo().alert().getText();

	}

	
	public void enterDataInPromtPopup(WebDriver driver , String string)
	{
		
		driver.switchTo().alert().sendKeys(string);
	}
	
	
	
	
	
	
	



}