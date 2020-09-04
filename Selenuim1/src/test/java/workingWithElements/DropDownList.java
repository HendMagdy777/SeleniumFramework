package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void TestDropDownList()
	{
		WebElement SOptions = Driver.findElement(By.id("dropdown"));
		Select options = new Select(SOptions);
		assertFalse(options.isMultiple());

		assertEquals(3, options.getOptions().size());
		options.selectByVisibleText("Option 1");
		//	options.selectByIndex(0);
		//options.selectByValue("1");

		assertEquals("Option 1", options.getFirstSelectedOption().getText());

	} 
	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
