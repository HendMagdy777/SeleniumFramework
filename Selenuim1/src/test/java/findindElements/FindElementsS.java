package findindElements;

import static org.testng.Assert.assertEquals;
 
//import java.awt.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsS {
	

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
	public void findallurls()
	{	
		// lw ktbt tag msh mwgod hyrg3 list fdya bs msh hydrb exception
		 List<WebElement> listofUrls = Driver.findElements(By.tagName("a"));
		 
		 //Verify Number of Links
		 assertEquals(46, listofUrls.size());  
		 System.out.println(listofUrls.size());
		 
		 for(WebElement link : listofUrls)
		 {
			 //kol link ygeb l url bt3o
			 System.out.println(link.getAttribute("href"));
			 // check for valid url  
			 
			 //Driver.navigate().to(link.getAttribute("href"));
			 
			 // can check tiltle and every thing using this link
		 }
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}
}

