package automation.PageObjects;


import org.openqa.selenium.support.PageFactory;

import automation.Logging.LogManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**This class contains page objects and their getter methods of Login page
 * 
 * @author anil Kaushik
 * 
 * */
public class LoginPageObjects {
	
	//locators
	private final String createAccountXpath="//android.view.View[@text='Create account. New to Amazon?']";
	
	private final String loginAccountXpath="//android.view.View[@text='Login. Already a customer?']";
	
	private final String accountInfoId="//android.widget.EditText[@resource-id='ap_email_login']";
	
	private final String continueButton="//android.widget.Button[@resource-id='continue']";
	
	private final String passwordField="//android.widget.EditText[@resource-id='ap_password']";
	
	
	private final String showPasswordCheckBox="//android.widget.CheckBox[@resource-id='auth-signin-show-password-checkbox']";
	
	private final String loginButton="//android.widget.Button[@resource-id='signInSubmit']";
	
	
	private final String homeScreen="//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo']";
	public LoginPageObjects(AndroidDriver<AndroidElement>driver)
	    {
	        try{
	            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        }catch(Exception e)
	        {
	        	LogManager.logException(e);
	        }
	    }
	  
	  
	//page factory to find locators
	   @AndroidFindBy(xpath=createAccountXpath)
	    private AndroidElement createAccountRadioButton;
	   
	   @AndroidFindBy(xpath=createAccountXpath)
	    private AndroidElement createAccountLabel;
	   
	   
	   @AndroidFindBy(xpath=loginAccountXpath)
	    private AndroidElement loginAccountRadioButton;
	   
	   @AndroidFindBy(xpath=loginAccountXpath)
	    private AndroidElement loginAccountLabel;
	   
	   @AndroidFindBy(xpath=accountInfoId)
	   private AndroidElement userAccountInfoBox;
	   
	   
	   @AndroidFindBy(xpath=continueButton)
	   private AndroidElement continueButtonElement;
	   
	   @AndroidFindBy(xpath=passwordField)
	   private AndroidElement passwordfieldElement;
	   
	   
	   @AndroidFindBy(xpath=showPasswordCheckBox)
	   private AndroidElement checkboxElement;
	   
	   
	   @AndroidFindBy(xpath=loginButton)
	   private AndroidElement loginButtonElement;
	   
	   
	   @AndroidFindBy(xpath=homeScreen)
	   private AndroidElement homeScreenElement;
	   
	   
	   // getter methods
	   
	   public AndroidElement getAccountInfoBox() {
		return userAccountInfoBox;
	   					}
	
	   public AndroidElement getCreateAccountLabel() {
	        return createAccountLabel;
	    }
	
	    public AndroidElement getLoginAccountLabel() {
	        return loginAccountLabel;
	    }
	    
		
	   
	  
	  
		   public AndroidElement createAccountRadioButton() {
		        return createAccountRadioButton;
		    }
		
		    public AndroidElement loginAccountRadioButton() {
		        return loginAccountRadioButton;
		    }
		    
		    public AndroidElement getContinuebuttonElement() {
		        return continueButtonElement;
		    }
		    
		    public AndroidElement getPasswordFieldElement() {
		        return passwordfieldElement;
		    }
	  
		    public AndroidElement getcheckBoxElement() {
		        return checkboxElement;
		    }
	  
	  
		    public AndroidElement getLoginButtonElement() {
		        return loginButtonElement;
		    }
	  
	  
	
		    
		    public AndroidElement getHomeScreenElement() {
		        return homeScreenElement;
		    }

}
