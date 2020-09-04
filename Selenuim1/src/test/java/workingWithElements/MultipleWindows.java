package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
 
import org.openqa.selenium.By; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		Driver.manage().window().maximize();
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
	public void TestWindowsUsingTiTle() throws InterruptedException 
	{  
		//Get original window id
		String OriginalWindowID = Driver.getWindowHandle();
		Driver.findElement(By.id("visitbutton")).click();

		for(String WindowID : Driver.getWindowHandles())
		{
			String title = Driver.switchTo().window(WindowID).getTitle();
			if (title.equals("Visit Us"))
			{
				assertEquals("Visit Us" , Driver.getTitle());
				Driver.close();
				//5las l2etha
				break;


			}}

		Driver.switchTo().window(OriginalWindowID);
		Thread.sleep(2000);

	}

	@Test
	public void TestWindowsUsingName() throws InterruptedException 
	{ 
	 String CurrentWindowId = Driver.getWindowHandle();
	 
	 Driver.findElement(By.id("helpbutton")).click();
	 
	 Driver.switchTo().window("HelpWindow");
	 assertEquals("Help", Driver.getTitle());
	 Driver.close();
	 Driver.switchTo().window(CurrentWindowId);
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}


}
