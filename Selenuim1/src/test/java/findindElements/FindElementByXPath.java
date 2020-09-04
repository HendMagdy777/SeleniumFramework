package findindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {
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

	@Test
	public void findallurlsXpath()
	{	//*[@id="username"]
		WebElement Username = Driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement Password = Driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement Button = Driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
		
		System.out.println(Username.getTagName());
		System.out.println(Password.getTagName());
		System.out.println(Button.getText());
	}
	
	@Test
	public void findallurlsPartialXPath()
	{	//*[@id="username"]
		WebElement Username = Driver.findElement(By.xpath("//input"));
		//WebElement Username = Driver.findElement(By.xpath("//input[0]"));
		WebElement Password = Driver.findElement(By.xpath("//input"));
		WebElement Button = Driver.findElement(By.xpath("/button"));
		
		System.out.println(Username.getTagName());
		System.out.println(Password.getTagName());
		System.out.println(Button.getText());
	}
	
	

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
