package findindElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElemetsByID {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/login");
		//Driver.navigate().to("http://the-internet.herokuapp.com/tables");


	}

	@Test(enabled = false)
	public void FindElementyID()
	{
		// Method 1
		Driver.findElement(By.id("username"));
		Driver.findElement(By.id("password"));

		//Method 2
		WebElement Username = Driver.findElement(By.id("username"));
		WebElement Password = Driver.findElement(By.id("password"));

		System.out.println(Username.getTagName());
		System.out.println(Password.getTagName());
	}

	@Test (enabled = false)
	public void FindElementbyName()
	{ 
		try {
			//Method 2
			WebElement Username = Driver.findElement(By.name("username"));
			WebElement Password = Driver.findElement(By.name("password"));

			System.out.println(Username.getTagName());
			System.out.println(Password.getTagName());
			System.out.println(Username.getLocation());
			System.out.println(Password.getRect());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Element not fount Please Use a valid attribute");
		}
	}

	@Test(enabled = false)
	public void FindElementbyClassName()
	{ 
		try {
			//Method 2
			WebElement Button = Driver.findElement(By.className("radius"));

			System.out.println(Button.getTagName());
			System.out.println(Button.getLocation());
			System.out.println(Button.getRect());
			System.out.println(Button.getText());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Element not fount Please Use a valid attribute");
		}
	}

	@Test(enabled = false)
	public void FindElementbyTagName()
	{ 
			//Method 2
			WebElement LoginButton = Driver.findElement(By.tagName("button"));
			LoginButton.click();
			 
	}
	
	@Test(enabled = false)
	public void FindElementInTablebyTagName()
	{ 
			//Method 2
			WebElement Table = Driver.findElement(By.id("table1"));
			 List<WebElement> All = Table.findElements(By.tagName("tr"));
			 System.out.println(All.size());
			 System.out.println(All.get(3).getText());
		
	}
	@Test
	public void FindElementInTablebyCSSSelector()
	{ 
			//Method 2
			WebElement BtnbyStyle = Driver.findElement(By.cssSelector("button.radius"));
			//WebElement Username = Driver.findElement(By.cssSelector("input#username"));
			 System.out.println(BtnbyStyle.getText());
			
	}


	@AfterTest

	public void CloseDriver()
	{
		Driver.quit();
	}


}
