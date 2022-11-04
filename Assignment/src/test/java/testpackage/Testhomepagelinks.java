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
public class Testhomepagelinks extends Base{
	
	String urlToday = "https://www.ticketswap.com/browse?period=today";
	String urlTomorrow = "https://www.ticketswap.com/browse?period=this-weekend";
	String urlDateLocationCategory = "https://www.ticketswap.com/browse";
	WebElement homeButton;
	
	@BeforeSuite
	public void initialSetup() throws InterruptedException {				
		initialization();	
	}
	
	@Parameters({"homeUrl"})
	@BeforeClass
	public void launchSite(String homeUrlName) throws InterruptedException {		
		driver.get(homeUrlName);
		driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();		
		threadWait();
	}
	
	@Test (priority=1)
	public void validateBrowseEventsTodayUrl() throws InterruptedException {
		WebElement browseByToday = driver.findElement(By.xpath("//a[@href='https://www.ticketswap.com/browse?period=today']"));		
		browseByToday.click();
		threadWait();
		String fetchbrowseByTodayUrl = driver.getCurrentUrl();		
		Assert.assertEquals(fetchbrowseByTodayUrl, urlToday);			
		homeButton = driver.findElement(By.xpath("//a[@aria-label='Homepage']"));
		homeButton.click();	
		threadWait();		
		js.executeScript("window.scrollBy(0,75)");
	}
	
	@Test (priority=2)
	public void validateBrowseEventsTomorrowUrl() throws InterruptedException {		
		WebElement browseByTomorrow = driver.findElement(By.xpath("//a[@href='https://www.ticketswap.com/browse?period=this-weekend']"));		
		browseByTomorrow.click();		
		threadWait();
		String fetchUrlBrowseByTomorrow = driver.getCurrentUrl();
		Assert.assertEquals(fetchUrlBrowseByTomorrow, urlTomorrow);
		homeButton = driver.findElement(By.xpath("//a[@aria-label='Homepage']"));
		homeButton.click();
		js.executeScript("window.scrollBy(0,75)");		
	}

	@Test (priority=3)
	public void validateBrowseEventsDateUrl() throws InterruptedException {		
		WebElement browseByDate = driver.findElement(By.xpath("//a[@href='https://www.ticketswap.com/browse']"));		
		browseByDate.click();		
		threadWait();
		String fetchUrlBrowseByDate = driver.getCurrentUrl();
		Assert.assertEquals(fetchUrlBrowseByDate, urlDateLocationCategory);
		homeButton = driver.findElement(By.xpath("//a[@aria-label='Homepage']"));
		homeButton.click();
		//Assert.assertTrue(false);
	}
	
	@AfterSuite
	public void closeSetup() {
		driver.quit();
	}
	
}
