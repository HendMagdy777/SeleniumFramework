package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class TextBoxandButtons {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
	String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
	System.setProperty("webdriver.chrome.driver", Path);
	Driver = new ChromeDriver();
	Driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void findallurlsXpath()
	{
		WebElement UsernameTxt = Driver.findElement(By.id("username"));
		WebElement PasswordTxt = Driver.findElement(By.id("password"));
		WebElement Button = Driver.findElement(By.className("radius"));
		
		UsernameTxt.clear();
		UsernameTxt.sendKeys("tomsmith");
		
		PasswordTxt.clear();
		PasswordTxt.sendKeys("SuperSecretPassword!");
		
		Button.click();
		
		// Make sure that we logged in successfully
		WebElement CheckLabel = Driver.findElement(By.id("flash"));
		System.out.println(CheckLabel.getText());
		Boolean x = CheckLabel.getText().contains("You logged into a secure area!");
		assertTrue(x);
		
	}
	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}
}
