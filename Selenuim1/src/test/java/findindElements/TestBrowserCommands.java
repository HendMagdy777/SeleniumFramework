package findindElements;

 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com");
		System.out.println(Driver.getCurrentUrl());
		//Driver.navigate().to("http://the-internet.herokuapp.com/tables");
	}

	@Test
	public void findallurlsXpath()
	{	Driver.navigate().to("https://the-internet.herokuapp.com/login");
	System.out.println(Driver.getCurrentUrl());
	Driver.navigate().back();
	System.out.println(Driver.getCurrentUrl());
	Driver.navigate().forward();
	System.out.println(Driver.getCurrentUrl());
	Driver.navigate().refresh();
	
	Driver.manage().window().maximize();
	
	}

	

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
