package automation.CommonUtilities;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import automation.AppiumServer.AppiumServerManager;

/**This class is a setup class to initialize all the resource like: properties file etc
 * 
 * @author anil Kaushik
 * 
 * */


public class InitializeResources{
	
	public static PropertyReader prop=null;
	
	@BeforeSuite
	public void setup()
	{
		try{
			 prop=new PropertyReader(System.getProperty("user.dir")+"//resources//config.properties");
		
			
			AppiumServerManager.startAppiumServer();
			
			
	

		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

	@AfterSuite
	public void tearDown()
	{
		try{
		
			AppiumServerManager.stopAppiumServer();

		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}




}
