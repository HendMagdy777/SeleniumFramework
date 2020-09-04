package workingWithElements;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		Driver.manage().window().maximize();
	} 
	@Test
	public void SwitchToFrameWithNameOrId()  
	{
		// 1. We need to move to be located on 1 specific frame to perform l code on it 
		// because each frame have the same elements so we need to be specified
		Driver.switchTo().frame("left");
		WebElement Mesg = Driver.findElement(By.tagName("p"));
		assertTrue(Mesg.getText().contains("This is Left Frame"));
		
		//yrg3 l bara 3ade bara l frma
		Driver.switchTo().defaultContent();

	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
