package workingWithElements;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTML5VideoPlayer {
	FirefoxDriver Driver ;

	@BeforeTest
	public void OpenUrl()
	{  String Path = System.getProperty("user.dir")+"//resources//geckodriver.exe";
		System.setProperty("webdriver.gecko.driver" , Path);
		Driver = new FirefoxDriver();  
		//	String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		Driver.navigate().to("http://cookbook.seleniumacademy.com/html5video.html");
	}

	@Test
	public void VideoPlayerTest() throws AWTException, InterruptedException, IOException 
	{	// i will need it in My JavaScript code
		WebElement Video = Driver.findElement(By.id("vplayer"));
		JavascriptExecutor JS = (JavascriptExecutor) Driver;
		// find source of video and put it into Video WebElement [ gwa properties l element]
		String Url = (String) JS.executeScript("return arguments(0).currentsrc", Video);
		// find video duration
		long duration = (long) JS.executeScript("return arguments(0).duration" , Video);
		assertEquals("http://html5demos.com/assets/dizzy.mp4", Url);
		assertEquals(25, duration);
		// h3ml run ll video bl javascript
		JS.executeScript("return arguments(0).play()" , Video);
		Thread.sleep(6000);
		JS.executeScript("return arguments(0).pause()" , Video);
		Thread.sleep(2000);
		File source = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/VideoPlayer.png"));
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
