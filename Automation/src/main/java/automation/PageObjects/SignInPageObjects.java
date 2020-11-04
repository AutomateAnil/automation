package automation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.Logging.LogManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**This class contains page objects and their getter methods of signIn page
 * 
 * @author anil Kaushik
 * 
 * */
public class SignInPageObjects {
	
	// locators
	private final String signIn="com.amazon.mShop.android.shopping:id/sign_in_button";
	private final String createAccount="com.amazon.mShop.android.shopping:id/new_user";
	private final String skipSignIn="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	
	  public SignInPageObjects(AndroidDriver<AndroidElement>driver)
	    {
	        try{
	            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        }catch(Exception e)
	        {
	        	LogManager.logException(e);
	        }
	    }
	  
	  
	  //page factory to find locators
	   @AndroidFindBy(id=signIn)
	    private WebElement signInButton;
	   
	   @AndroidFindBy(id=createAccount)
	    private WebElement createAccountButton;
	   
	   
	   @AndroidFindBy(id=skipSignIn)
	    private WebElement skipSignInButton;
	   
	   
	   //--getter methods for locators-------
	   
	   // getter for sign in button
	   public WebElement getSignInButton() {
	        return signInButton;
	    }
	// getter for create Account button
	    public WebElement getCreateAccountButton() {
	        return createAccountButton;
	    }
	    
		// getter for create skip Sign in button
	    public WebElement getSkipSignInButton() {
	        return skipSignInButton;
	    }
	    
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
