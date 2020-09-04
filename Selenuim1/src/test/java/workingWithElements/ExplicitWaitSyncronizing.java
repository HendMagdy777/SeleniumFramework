package workingWithElements;

import static org.testng.Assert.assertTrue;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitSyncronizing {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://www.google.com");
		Driver.manage().window().maximize();
	} 
	@Test
	public void ExplicitWait() 
	{  
	  WebElement QueryText = Driver.findElement(By.name("q"));
	  QueryText.sendKeys("selenium Webdriver");
	  QueryText.submit();
	 // QueryText.click();
	  
	  //1.Time
	  WebDriverWait ExplicitWait = new WebDriverWait(Driver, 20);
	  //2.Expected Contation
	  ExplicitWait.until(ExpectedConditions.titleContains("selenium"));
	  assertTrue(Driver.getTitle().toLowerCase().startsWith("selenium"));
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
