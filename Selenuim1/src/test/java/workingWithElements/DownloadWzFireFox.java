package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadWzFireFox {

	// FireFox bys2lna lma n3ml download by2oli open wla save as 
	FirefoxDriver Driver ;
	

	// h7add mkan l downloads
	public static String DownloadsPath =  System.getProperty("user.dir")+"\\Downloads";
	
	
	public static FirefoxOptions FirefoxOptionsCustom()
	{
		FirefoxOptions Option = new FirefoxOptions();
		// 7ot l haga f mkan custom msh l default lw 0 yb2a l default lw 8er 0 da custom
		// b3dha b3olo mkan l download path eh l hy7ot feh l hwa mkan l custom da
		Option.addPreference("browser.download.dir", DownloadsPath);
		
		Option.addPreference("browser.download.folderlist", 2);
	
		//mts2lnesh a3ml save wla open with l kol anwa3 l files l h3mlha download
		Option.addPreference("browser.helperApps.neverAsk.saveToDisk" , "application/octet-stream");

	//	Option.addPreference("browser.helperApps.neverAsk.saveToDisk" ,
		//	     "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		 
	//	Mtzhrsh l box tani abl l download
		Option.addPreference("browser.download.manager.showWhenStarting" , false);
		
		
		return Option;
		
		
	}
 
	@BeforeTest
	public void OpenUrl()
	{  
		
		System.out.println(DownloadsPath);
	String Path = System.getProperty("user.dir")+"//resources//geckodriver.exe";
	System.setProperty("webdriver.gecko.driver" , Path);
	Driver = new FirefoxDriver(FirefoxOptionsCustom());
	Driver.navigate().to("https://the-internet.herokuapp.com/download"); 
	 
	}
	
	@Test
	public void DownloadWzFireFox() throws AWTException, InterruptedException 
	{ // m7taga a2olo 5alek fl silent mode msh eno ys2lne 3ayz save as wla open
		
	Driver.findElement(By.linkText("some-file.txt")).click();
 
	
	Thread.sleep(2000);
	}
	@AfterTest
	public void CloseDriver()
	{Driver.close();
	}
}
