package testpackage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Customlistener.class)
public class Testtwo3 extends Base {

	String txtHelp = "How can we help?";

	@BeforeSuite
	public void initialSetup() throws InterruptedException {
		initialization();
	}

	@Parameters({ "homeUrl" })
	@BeforeClass
	public void launchSite(String homeUrlName) throws InterruptedException {
		driver.get(homeUrlName);
		driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
		threadWait();
	}

	@Test
	public void validateHelpLink() throws InterruptedException {
		js.executeScript("window.scrollBy(0,3000)");
		WebElement btnHelp = driver.findElement(By.xpath("//button[normalize-space()='Get help']"));
		btnHelp.click();
		threadWait();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='intercom-messenger-frame']")));
		WebElement eleHelp = driver.findElement(By.xpath("//h2[normalize-space()='How can we help?']"));
		String lblHelp = eleHelp.getText();
		Assert.assertEquals(lblHelp, txtHelp);
		driver.findElement(By.xpath("//button[@data-testid='messages']")).click();
		threadWait();
		driver.findElement(By.xpath("//button[@data-testid='help']")).click();
		threadWait();
		driver.findElement(By.xpath("//button[@data-testid='news']")).click();
		threadWait();
		driver.findElement(By.xpath("//button[@data-testid='home']")).click();
		threadWait();
		driver.switchTo().defaultContent();
	}

	@AfterSuite
	public void closeSetup() {
		driver.quit();
	}

}
