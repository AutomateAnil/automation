package automation.Listeners;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import automation.CommonUtilities.UtilitityFunctionsManager;
import automation.Logging.LogManager;

/**This class is implementation of ITestListener
 * 
 * @author anil Kaushik
 * 
 * */

public class ListenerManager  implements ITestListener   {
	
	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		LogManager.startTestCase(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		String testMethodName=result.getMethod().getConstructorOrMethod().getName();
		String testClassName=result.getMethod().getTestClass().getName();
		System.out.println(">>>>>>>>>"+result.getTestName());
		UtilitityFunctionsManager.takeFullScreenshot(testMethodName);
		LogManager.logException(testClassName,testMethodName, result.getThrowable());
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
	
	
	
	
	
	
	
	
}
