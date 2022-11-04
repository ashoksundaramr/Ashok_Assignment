package testpackage;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Customlistener extends Base implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test: "+result.getMethod().getMethodName()+"- Failed");
		takeScreenshot(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test: "+result.getMethod().getMethodName()+"- Passed");
	}
	
}
