package testpackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public static WebDriver driver;
	static JavascriptExecutor js;
	
	public static void initialization() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		js = (JavascriptExecutor) driver;
	}
	
	public static void takeScreenshot(String testMethodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("D:\\Ticketswap\\Screenshots\\"+testMethodName+"_Failed"+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void threadWait() throws InterruptedException {
		Thread.sleep(2000);
	}
}
