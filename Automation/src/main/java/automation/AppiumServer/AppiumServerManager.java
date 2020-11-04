package automation.AppiumServer;
import automation.Logging.LogManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;


/**This class is a Utility class to start and stop the appium server
 * @author anil kaushik
 *  
 *  */
public class AppiumServerManager{
	
	private static AppiumDriverLocalService service=null;
	
	private static  boolean isServerStarted=false;
	
	public static void startAppiumServer()
	{
		
		try {
			service=AppiumDriverLocalService.buildDefaultService();
			if(service!=null)
			{
				service.start();
				isServerStarted=true;
				
			}
		}catch(Exception e)
		{
			
			isServerStarted=false;	
			
			LogManager.logException(e);
		}	
		
	}
	
	
	
	public static void stopAppiumServer()
	{
		try {
			if(isServerStarted)
			{
				if(service!=null)
				{
					service.stop();
					isServerStarted=false;
				}
			}
		}
		catch(Exception e)
		{
			LogManager.logException(e);
		}
	}
	
	
	
	
	
	
	

}
