package workingWithElements;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://www.amazon.com");
		Driver.manage().window().maximize();
	} 
	@Test
	public void ScreenShotTest() throws InterruptedException  
	{  // Make Method to be failed
		WebElement SearchBox = Driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("selenium webdriver");
		SearchBox.submit();
		assertTrue( Driver.getTitle().contains("selenium webdriverXX"));
	}

	@AfterMethod
	public void TakeaScreenshot(ITestResult res) throws IOException
	{
		if(ITestResult.FAILURE == res.getStatus())
		{
			TakesScreenshot TS = (TakesScreenshot) Driver;
			File source = TS.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" +res.getName() +".png"));
		}
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
