package workingWithElements;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptCode {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  	String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://www.google.com");
		Driver.manage().window().maximize();
	}
	
	@Test
	public void TestJavaScript()  
	{ 
		//Cast driver to JS Code
		JavascriptExecutor JS = (JavascriptExecutor) Driver;
		//3yza ageb l title b javascript // da code JAva script l ben "" bs 3yza a3mlo run bl selenuim driver
		String Title = JS.executeScript("return document.title").toString();
		System.out.println(Title);
		assertEquals("Google", Title);
 
		long var = (long) JS.executeScript("var links = document.getElementsByTagName('A'); return links.length;");
		System.out.println(var);
		assertEquals(19 , var);
	}

	
	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
