package automation.Automation;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.CommonUtilities.DriverManager;
import automation.CommonUtilities.UtilitityFunctionsManager;
import automation.Logging.LogManager;
import automation.PageObjects.SignInPageObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**This class contains tests for Sign In functionality
 * 
 * @author anil Kaushik
 * 
 * */
public class SignInPageTest {
	
	
	SignInPageObjects si;
	AndroidDriver<AndroidElement> driver;
	UtilitityFunctionsManager ufm;
	
	@BeforeClass
	public void testSetup()
	{
		try {
		driver=DriverManager.getDriver();
		ufm=new UtilitityFunctionsManager(driver);
		si=new SignInPageObjects(driver);
	
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
		
	}
	
	@Test
	public void signInButtonTest()
	{
		boolean clicked=UtilitityFunctionsManager.clickElement(si.getSignInButton());
		Assert.assertTrue(clicked);
		
	}
	
	
	@BeforeClass
	public void tearDown()
	{
		try {
		
	
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
		
	}

}
