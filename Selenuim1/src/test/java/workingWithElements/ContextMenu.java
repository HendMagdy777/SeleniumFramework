package workingWithElements;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Driver.manage().window().maximize();
	} 
	
	@Test
	public void TestScrollJavaScript() throws InterruptedException  
	{   
		WebElement Button = Driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement MenuItem = Driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

		Actions Builder = new Actions(Driver);
		Builder.contextClick(Button).moveToElement(MenuItem).click().perform();

		// Expected that alert to be Displayed so i will  wait for it
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		Alert alert  = wait.until(ExpectedConditions.alertIsPresent());

		assertEquals("clicked: edit", alert.getText());

		alert.dismiss();
	}

	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
