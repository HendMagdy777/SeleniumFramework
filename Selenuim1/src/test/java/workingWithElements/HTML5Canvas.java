package workingWithElements;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTML5Canvas {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
		Driver.manage().window().maximize();
	} 
	@Test
	public void CanvasTest() throws InterruptedException, IOException  
	{   WebElement drawLIst = Driver.findElement(By.id("dtool"));
		WebElement drawArea = Driver.findElement(By.id("imageTemp"));

		Select DrowTool = new Select(drawLIst);
		DrowTool.selectByValue("pencil");
		
		Actions builder = new Actions(Driver);
		builder.clickAndHold(drawArea).moveByOffset(10 , 50).moveByOffset(50 ,  10).
		moveByOffset(-10 , -50).moveByOffset(-50,-10).release().perform();

		Thread.sleep(2000);

		File source = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/Canvas.png"));
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
