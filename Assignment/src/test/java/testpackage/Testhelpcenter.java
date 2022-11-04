package testpackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Customlistener.class)
public class Testhelpcenter extends Base {

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
