package workingWithElements;


import java.util.NoSuchElementException;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {

	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	} 

	public boolean iselementPresent(By by)
	{try {
		Driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;
	}
	}

	@Test
	public void TestDropDownList() throws InterruptedException
	{
		// Find 1ST Checkbox by XPATH
		if(iselementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]")))
		{
			WebElement ChckBox1 = Driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			ChckBox1.click();
			ChckBox1.clear();
			Thread.sleep(1000);

			WebElement ChckBox2 = Driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

			if(!ChckBox2.isSelected())
			{
				ChckBox2.click();

				Thread.sleep(1000);

			}


		}
		else
		{
			Assert.fail("Not exist");
		
		}
		}








	


	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

	}
