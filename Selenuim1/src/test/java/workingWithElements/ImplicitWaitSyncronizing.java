package workingWithElements;
 
import static org.testng.Assert.assertTrue;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWaitSyncronizing {
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
	@Test
	public void ImplicitWait() 
	{ 
		//Implicit Wait for 20 second
	  Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Driver.findElement(By.linkText("Page 4")).click();
	 
	  WebElement Msg = Driver.findElement(By.id("page4"));
	  assertTrue( Msg.getText().contains("Nunc nibh tortor"));
	  
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}


}
