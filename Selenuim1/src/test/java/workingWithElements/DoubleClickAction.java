package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickAction {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	} 

	public boolean iselementPresent(By by)
	{try {
		Driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;
	}
	}

	@Test
	public void DoubleClick() 
	{
		WebElement Img = Driver.findElement(By.id("message"));
		System.out.println(Img.getCssValue("background-color"));
		Actions Builder = new Actions(Driver);
		Builder.doubleClick(Img).perform();
		System.out.println(Img.getCssValue("background-color"));
		assertEquals(Img.getCssValue("background-color"), "rgba(255, 255, 0, 1)");
		//Thread.sleep(20000);
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
