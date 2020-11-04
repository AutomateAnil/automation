package automation.Automation;


import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.CommonUtilities.DriverManager;
import automation.CommonUtilities.InitializeResources;
import automation.CommonUtilities.PropertyReader;
import automation.CommonUtilities.UtilitityFunctionsManager;
import automation.Logging.LogManager;
import automation.PageObjects.LoginPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**This class contains tests for Login functionality
 * 
 * @author anil Kaushik
 * 
 * */
public class LoginPageTest {
	
	

	LoginPageObjects lpo;
	AndroidDriver<AndroidElement> driver;
	UtilitityFunctionsManager ufm;
	PropertyReader pr;
	
	@BeforeClass
	public void testSetup()
	{
		try {
		driver=DriverManager.getDriver();
		ufm=new UtilitityFunctionsManager(driver);
		lpo=new LoginPageObjects(driver);
	
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
		
	}
	
	@Test
	public void createAccountLableTest()
	{
		String   lableText=UtilitityFunctionsManager.getText(lpo.createAccountRadioButton());

		Assert.assertEquals(InitializeResources.prop.getValue("createAccountLable"),  lableText);
		
		
	}
	
	
	@Test
	public void LoginAccountLableTest()
	{
		String   lableText=UtilitityFunctionsManager.getText(lpo.loginAccountRadioButton());
		Assert.assertEquals(InitializeResources.prop.getValue("loginLable"), lableText);
		
		
	}
	
	@Test
	public void loginTest()
	{
		try {
		UtilitityFunctionsManager.setText(lpo.getAccountInfoBox(), InitializeResources.prop.getValue("username"));
		boolean isTapSuccessful=UtilitityFunctionsManager.tapElement(lpo.getContinuebuttonElement());
		Assert.assertTrue(isTapSuccessful);
		
		UtilitityFunctionsManager.setText(lpo.getPasswordFieldElement(), InitializeResources.prop.getValue("password"));
		String  propVal=UtilitityFunctionsManager.getElementProperty(lpo.getcheckBoxElement(), "checked");
		
		// assert show password checkbox is by default checked
		Assert.assertTrue(Boolean.parseBoolean(propVal));
		isTapSuccessful=UtilitityFunctionsManager.tapElement(lpo.getLoginButtonElement());
		Assert.assertTrue(isTapSuccessful);
		
		String val=UtilitityFunctionsManager.getElementProperty(lpo.getHomeScreenElement(), "content-desc");
		Assert.assertEquals(InitializeResources.prop.getValue("amazonHomeScreenVerifier"), val);
		
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
	
	@AfterClass
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
