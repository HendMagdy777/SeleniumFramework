package workingWithElements;


import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToButtonJavaScript {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://www.amazon.com");
		Driver.manage().window().maximize();
	} 
	@Test
	public void TestScrollJavaScript() throws InterruptedException  
	{  
		JavascriptExecutor JS = (JavascriptExecutor) Driver;
		JS.executeScript("scrollBy (0 , 4500)");
		//	Thread.sleep(2000);
		
		//TRICK 3mlna b CSSSelector l Inside l DIV w any space n3mlaha replace b .
		// if el tag with name Class so its related to CSSSelector
		// any space should be replaced with [.]
		WebElement Logo = Driver.findElement(By.cssSelector ("div.nav-logo-base.nav-sprite"));
		
		// Check Existence of WebElement[ Displayed Correctly not crashed]
		assertTrue(Logo.isDisplayed());
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
