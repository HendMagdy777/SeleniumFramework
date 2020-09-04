package workingWithElements;

import static org.testng.Assert.assertEquals;
 
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropActions {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
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
	public void DragAndDrop() 
	{ WebElement Source = Driver.findElement(By.id("draggable"));
  	 WebElement Dest = Driver.findElement(By.id("droppable"));
  	 Actions Builder = new Actions(Driver);
  	 Builder.dragAndDrop(Source, Dest).perform();
  	 assertEquals(Dest.getText(), "Dropped!");
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
