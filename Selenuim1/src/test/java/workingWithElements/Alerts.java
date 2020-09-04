package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	} 

	public boolean iselementPresent(By by)
	{try {
		Driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;
	}
	}

	@Test(enabled = false)
	public void AlertTest() 
	{ WebElement AlertButton = Driver.findElement(By.id("simple"));
	AlertButton.click();
	Alert alert = Driver.switchTo().alert();
	String Atext = alert.getText();
	assertEquals("Hello! I am an alert box!" ,  Atext);
	//accept popup alert msg to continue
	alert.accept();
	 }
	
	@Test(enabled = false)
	public void PrompotAlter() throws InterruptedException 
	{ WebElement AlertButton = Driver.findElement(By.id("prompt"));
	AlertButton.click();
	
	Alert alert = Driver.switchTo().alert();
	alert.sendKeys("Harry Potter");
	alert.accept();
	
	WebElement msg = Driver.findElement(By.id("prompt_demo"));
	assertEquals("Hello Harry Potter! How are you today?" ,  msg.getText());
	//accept popup alert msg to continue
	Thread.sleep(2000);
 
	 }
	@Test
	public void ConfirmPrompotAltet() throws InterruptedException 
	{ WebElement AlertButton = Driver.findElement(By.id("confirm"));
	AlertButton.click();
	//accept popup alert msg to continue
	Alert alert = Driver.switchTo().alert();
	 
	alert.accept();
	
	WebElement msg = Driver.findElement(By.id("demo"));
	assertEquals("You Accepted Alert!" ,  msg.getText());
	
	Thread.sleep(2000);
 
	 }
	

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}


}
