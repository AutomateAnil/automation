package automation.CommonUtilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.Logging.LogManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

/**This class contains utility methods of Appium api like: findElement,tap,scroll etc
 * 
 * @author anil Kaushik
 * 
 * */

public class UtilitityFunctionsManager {
	
	
	
	private static AndroidDriver<AndroidElement> driver;
	static WebDriverWait wait;
	static TouchAction ta;
	
	public UtilitityFunctionsManager(AndroidDriver<AndroidElement> appDriver)
	{
		driver=appDriver;
		wait= new WebDriverWait(driver,30);
		ta=new TouchAction(driver);
	}
	
	
	
	public static void takeFullScreenshot(String testCaseName)
	{
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File( System.getProperty("user.dir")+"\\screenShot\\"+testCaseName+System.currentTimeMillis()+".png"));
		}
		catch(Exception e)
		{
			LogManager.logException(e);
			
		}
	}
	
	public static void takeScreenshotOfElement(String testCaseName,WebElement element)
	{
		
		try {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			int x=element.getLocation().getX();
			int y=element.getLocation().getY();
			
			int imageWidth=element.getSize().getWidth();
			int imageHeight=element.getSize().getHeight();
			
			BufferedImage img = ImageIO.read(screen);
			BufferedImage destination = img.getSubimage(x, y, imageWidth, imageHeight);
			ImageIO.write(destination, "png", screen);
			FileUtils.copyFile(screen, new File(System.getProperty("user.dir")+"\\screenShot\\"+testCaseName+element.toString()+".png"));
			
		}
		catch(Exception e)
		{
			LogManager.logException(e);
			
		}
	}
	
	public  static void scrollIntoView(String text)
	{
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
		
		
	}
	
	
	public static void pressBackButton()
	{
		KeyEvent ke=new KeyEvent();
		
		driver.pressKey(ke.withKey(AndroidKey.BACK));
	}
	
	
	public static boolean clickElement(WebElement element)
	{
		boolean isClickSuccess=false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			isClickSuccess=true;
		}
		catch(Exception e)
		{
			isClickSuccess=false;
			LogManager.logException(e);
		}
		
		return isClickSuccess;
	}
	
	
	public static boolean inputData(WebElement element,String data)
	{
		boolean isInputSuccess=false;
		try {
			
			element.sendKeys(data);;
			isInputSuccess=true;
		}
		catch(Exception e)
		{
			isInputSuccess=false;
			LogManager.logException(e);
		}
		
		return isInputSuccess;
	}
	
	
	
	//get an webelement 
		public static WebElement getElement(final String locator,String by)
		{
			AndroidElement element = null;
			try{
			if(by.equals("id"))
			
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				element= driver.findElement(By.id(locator));
			}
			else if(by.equals("xpath"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				element= driver.findElement(By.xpath(locator));
				
			}
		
			
			else if(by.equals("classname"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
				element= driver.findElement(By.className(locator));
			}
			
			}
			catch(Exception e)
			{
				LogManager.logException(e);
				
			}
			return element;
			
			
		}
		
		
		
		public static WebElement getElement(final String text)
		{
			AndroidElement element = null;
			try{
		
				element= driver.findElementByAndroidUIAutomator("text(\""+text+"\")");
			
			
			}
			catch(Exception e)
			{
				LogManager.logException(e);
				
			}
			return element;
			
			
		}
	
		
		
		public static String getText(AndroidElement element)
		{
			String data="";
			try{
		
				data=element.getText();
			
			
			}
			catch(Exception e)
			{
				LogManager.logException(e);
				
			}
			return data;
			
			
		}
		
		
		
		public static Boolean elementState(WebElement element,String state)
		{
			boolean  status=false;
			try{
		
				if(state.equalsIgnoreCase("selected"))
				{
					
					status=element.isSelected();
				}
				else if(state.equalsIgnoreCase("enabled"))
				{
					status=element.isEnabled();
				}
				else if(state.equalsIgnoreCase("displayed"))
				{
					status=element.isDisplayed();
				}
			
			}
			catch(Exception e)
			{
				LogManager.logException(e);
				
			}
			return status;
			
			
		}
		
		
		
		
		
		public static void setText(WebElement element,String text)
		{
			try{
				//element.click();
				element.clear();
				element.sendKeys(text);
			}
			catch(Exception e)
			{
				LogManager.logException(e);
			}
		}
		
		
		
		public static boolean tapElement(WebElement element)
		{
			boolean tapSuccessfull=false;
			try {
			TapOptions to=new TapOptions();
			//ElementOption eo=new ElementOption();
			ta.tap(to.withElement(ElementOption.element(element))).perform();
			tapSuccessfull=true;
			}
			catch(Exception e)
			{
				tapSuccessfull=false;
				LogManager.logException(e);
			}
			return tapSuccessfull;
			
		}

		public static String getElementProperty(WebElement element,String property)
		{
			String data="";
			try {
				data=element.getAttribute(property);
				
			}
			catch(Exception e)
			{
				LogManager.logException(e);
			}
			
			return data;
		}
		
		public static void pressAnyKey(AndroidKey key)
		{
			
			KeyEvent k=new KeyEvent();
			k.withKey(key);
			driver.pressKey(k);
		}
		
		
		public static void verticalScroll(final String classNamelocator,String textToSearch)
		{
			try {
			driver.findElement(
					MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().className(\""+classNamelocator+"\")).setAsVerticalList().scrollIntoView(text(\""+textToSearch+"\"))"));
			Assert.assertTrue(true);
			}
			catch(Exception e)
			{
				Assert.assertTrue("scrollFail",false);
			}
			
		}
		
		public static void horizontalScroll(final String classNamelocator,String textToSearch)
		{
			driver.findElement(
					MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().className(\""+classNamelocator+"\")).setAsHorizontalList().scrollIntoView(text(\""+textToSearch+"\"))"));
			
			
			
		}
		
		
		public static List<AndroidElement> getElements(final String locator,String by)
		{
			List<AndroidElement>element = null;
			try{
			if(by.equals("id"))
			
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				element= driver.findElements(By.id(locator));
			}
			else if(by.equals("xpath"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				element= driver.findElements(By.xpath(locator));
				
			}
		
			
			else if(by.equals("classname"))
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
				element= driver.findElements(By.className(locator));
			}
			
			}
			catch(Exception e)
			{
				LogManager.logException(e);
				
			}
			return element;
			
			
		}
		
		
		
}
