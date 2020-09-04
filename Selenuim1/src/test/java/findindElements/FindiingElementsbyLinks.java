package findindElements;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindiingElementsbyLinks {


	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com");
		//Driver.navigate().to("http://the-internet.herokuapp.com/tables");
	}

	@Test
	public void findlinks()
	{
		WebElement Link = Driver.findElementByLinkText("Elemental Selenium");
		System.out.println(Link.getAttribute("href"));
	}

	@Test
	public void findlinksPartial()
	{
		//Nos l klma bs
		WebElement Link = Driver.findElementByPartialLinkText("Elemental");
		System.out.println(Link.getAttribute("href"));
	}
	
	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}
}
