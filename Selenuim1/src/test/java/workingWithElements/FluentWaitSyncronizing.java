package workingWithElements;

import static org.testng.Assert.assertTrue;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FluentWaitSyncronizing {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		Driver.manage().window().maximize();
	} 
	@SuppressWarnings("deprecation")
	@Test
	public void FluentWait() 
	{  Driver.findElement(By.cssSelector("#Page4")).click();
	
		Wait<WebDriver> WaitDriver = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(Driver)
				.withTimeout(20 , TimeUnit.SECONDS).pollingEvery(2 , TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement msg = WaitDriver.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.id("Page4"));
			}
			});
		assertTrue(msg.getText().contains("Nunc nibh tortor"));
		
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
