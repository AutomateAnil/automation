package automation.Automation;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.CommonUtilities.DriverManager;
import automation.CommonUtilities.InitializeResources;

import automation.CommonUtilities.UtilitityFunctionsManager;
import automation.Logging.LogManager;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

/**This class contains tests for product search,add to cart and check cart functionality
 * 
 * @author anil Kaushik
 * 
 * */
public class ProductSearchTest {
	
	AndroidDriver<AndroidElement> driver;
	UtilitityFunctionsManager ufm;
	
	
	@BeforeClass
	public void testSetup()
	{
		try {
		driver=DriverManager.getDriver();
		ufm=new UtilitityFunctionsManager(driver);
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
	}
	
	// product serach test
	@Test
	public void SearchProduct()
	{
		try {
		WebElement element=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("locatorForSearchProductBox"), "xpath");
		element.click();
		Thread.sleep(3000);
		
		// example of Android key events
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.F);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.I);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.T);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.B);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.A);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.N);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.D);
		UtilitityFunctionsManager.pressAnyKey(AndroidKey.ENTER);
		
		//vertical scroll
		UtilitityFunctionsManager.verticalScroll(InitializeResources.prop.getValue("scrollerClassName"), InitializeResources.prop.getValue("productTosearch"));
		
		
		List<AndroidElement>products=UtilitityFunctionsManager.getElements(InitializeResources.prop.getValue("productTitles"), "xpath");
		
		Assert.assertTrue(products.size()>1);
		for(AndroidElement el:products)
		{
			
			if(el.getText().equals(InitializeResources.prop.getValue("productTosearch"))) {
				
				boolean istapped=UtilitityFunctionsManager.tapElement(el);
				
				Assert.assertTrue(istapped);
				break;
			}
			
		}
		
		//verify product info page has appeared
		//UtilitityFunctionsManager.scrollIntoView("ADD TO WISH LIST");
		
		WebElement product=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("productName"));
		Assert.assertTrue(UtilitityFunctionsManager.elementState(product, "displayed"));
			}
		catch(Exception e)
		{
		LogManager.logException(e);
		}
		
	}
	
	// add to cart and verify count
	
	@Test
	public void addToCart()
	{
		WebElement element=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("cartXpath"), "xpath");
		String carValBeforeAddingProduct=UtilitityFunctionsManager.getElementProperty(element, "text");
		Assert.assertEquals(0, Integer.parseInt(carValBeforeAddingProduct));
		UtilitityFunctionsManager.verticalScroll("android.widget.LinearLayout","Qty:");
		UtilitityFunctionsManager.getElement("Add to Cart").click();
		 element=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("cartXpath"), "xpath");
		 String carValAfterAddingProduct=UtilitityFunctionsManager.getElementProperty(element, "text");
		Assert.assertEquals(1, Integer.parseInt(carValAfterAddingProduct));
		
		
		
	}
	
	
	//verify cart page and match added product is right one
	@Test
	public void cart()
	{
		WebElement  element=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("cartXpath"), "xpath");
		boolean tapSuccessfull=UtilitityFunctionsManager.tapElement(element);
		Assert.assertTrue(tapSuccessfull);
		WebElement productElement=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("productName"));
		String inCartProductName=UtilitityFunctionsManager.getElementProperty(productElement, "text");
		Assert.assertEquals(InitializeResources.prop.getValue("productName"), inCartProductName);
		
		

		//procced to buy
		WebElement  proceedToBuyElement=UtilitityFunctionsManager.getElement(InitializeResources.prop.getValue("proccedToBuyButton"));
		boolean state=UtilitityFunctionsManager.elementState(proceedToBuyElement, "displayed");
		Assert.assertTrue(state);
		
		
	}
	
	//logout from app
	@AfterClass
	public void tearDown()
	{
		try {
			
			
			
			driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon']")).click();
			
			UtilitityFunctionsManager.scrollIntoView("Settings");
			
		WebElement settingElement=	UtilitityFunctionsManager.getElement("Settings");
		
		UtilitityFunctionsManager.tapElement(settingElement);
		WebElement signoutLinkElement=	UtilitityFunctionsManager.getElement("Not anil? Sign out");
		
		UtilitityFunctionsManager.tapElement(signoutLinkElement);
		
		WebElement signoutElement=	UtilitityFunctionsManager.getElement("SIGN OUT");
		
		UtilitityFunctionsManager.tapElement(signoutElement);
		
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
		
	}

}
