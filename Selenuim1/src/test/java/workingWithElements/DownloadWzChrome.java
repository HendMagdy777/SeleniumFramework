package workingWithElements;

import java.awt.AWTException;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadWzChrome {
	ChromeDriver Driver ;
	// h7add mkan l downloads
	public static String DownloadsPath =  System.getProperty("user.dir")+"\\Downloads";
	public static ChromeOptions ChromeOptionsCustomized()
	{
		ChromeOptions option = new ChromeOptions();
		// like array bs 2 d leha key w value
		HashMap<String, Object> ChromePrefs = new HashMap<String, Object>();
		// Default behavior in Chrome that it have no Popups
		ChromePrefs.put("profile.default_content_settings.popups" , 0);
		ChromePrefs.put("download.default_directory" ,DownloadsPath );
		option.setExperimentalOption("prefs", ChromePrefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;

	}
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver(ChromeOptionsCustomized());
		Driver.navigate().to("https://the-internet.herokuapp.com/download");
	}

	@Test
	public void DownloadFileWithChrome() throws AWTException, InterruptedException 
	{
		Driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}
}
