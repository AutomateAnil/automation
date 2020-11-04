package automation.CommonUtilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import automation.Logging.LogManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
/**This class contains factory  method to get AndroidDriver instance
 * 
 * @author anil Kaushik
 * 
 * */

public class DriverManager {
	
	private   AndroidDriver<AndroidElement> driver=null;
	private static DriverManager dm;
	
	private  DriverManager()
	{
		try {
			
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
			//String driverExePath=WebDriverManager.chromedriver().getBinaryPath();
			DesiredCapabilities ds=new DesiredCapabilities();
		
			File appDir = new File("resources");
		    File app = new File(appDir, InitializeResources.prop.getValue("nonNativeAppName"));
		    ds.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			 ds.setCapability("appPackage", InitializeResources.prop.getValue("appPackage"));
			ds.setCapability("appActivity", InitializeResources.prop.getValue("appActivity"));
			ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			ds.setCapability("deviceName","SM-G610F");
			ds.setCapability("platformVersion", "8.1.0");
			ds.setCapability(MobileCapabilityType.NO_RESET, "true");
			ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			driver=new AndroidDriver<>(url,ds);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			catch(Exception e)
			{
				LogManager.logException(e);
			}
			
			
			
	}

	
	
	public static AndroidDriver<AndroidElement> getDriver()
	{
		
		if(dm==null)
		{
			dm=new DriverManager();
		}
		
		return dm.driver;
	}
	
	
	


}
