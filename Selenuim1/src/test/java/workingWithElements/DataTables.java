package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataTables {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}

	@Test
	public void TestDropDownList() throws InterruptedException
	{
		//GET ALL TABLE
		
		WebElement Table = Driver.findElement(By.id("table1"));
		List<WebElement> Rows = Table.findElements(By.tagName("tr"));

		assertEquals(5, Rows.size());

		for(WebElement row : Rows)
		{
			List<WebElement>  Cols= row.findElements(By.tagName("td"));
			for(WebElement col : Cols)
			{
				System.out.println(col.getText());
			}
			System.out.println("\t");
		}
	} 

	@Test
	public boolean iselementPresent(By by)
	{try {
		Driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;
	}




	}
	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
