package automation.Logging;

import org.apache.log4j.xml.DOMConfigurator;

/**This class contains utility methods for logging to file
 * 
 * @author anil Kaushik
 * 
 * */

import org.apache.log4j.Logger;

public class LogManager {

	static {
		DOMConfigurator.configure("log4j.xml");
	}
	
private static Logger log=Logger.getLogger(LogManager.class.getName());
	
	
	public static void startTestCase(String testCaseName)
	{
		log.info("------------------- "+testCaseName+" started--------------");
		
		
	}

	
	
	public static void endTestCase(String testCaseName)
	{
		log.info("-------------------testCase ended----------------"+testCaseName);
		
		
	}

	
	
	  public static void logException(Exception e) {
	  log.debug("Exception Occured: ",e); }
	 
	
	
	public static void logMessage(String message)
	{
		log.info(message);
		
	}
	
	
	public static void logException(String testClassName,String methodName,Throwable t)
	{
		log.debug("Exception in "+methodName+" of "+testClassName+" :", t);
		
	}
	
	
	
	
}
