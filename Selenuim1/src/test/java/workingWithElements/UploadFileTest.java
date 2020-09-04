package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileTest {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}

	@Test
	public void UploadFileUsingRepot() throws AWTException 
	{
		//Type is file so it's simple
		// so kda msh hynf3 sendkeys
		String ImgName = "HebaBD";
		String ImgPath = System.getProperty("user.dir")+"\\Upload\\"+ImgName;
		WebElement ChooseFileButton = Driver.findElement(By.id("file-upload"));
		ChooseFileButton.sendKeys(ImgPath);
		ChooseFileButton.click();
		
		System.out.println(ImgPath);
		
		WebElement UploadFileButton = Driver.findElement(By.id("file-submit"));
		UploadFileButton.click();
		WebElement UploadedLabel = Driver.findElement(By.id("uploaded-files"));
		System.out.println(UploadedLabel.getText());
		assertEquals(ImgName, UploadedLabel.getText());

	}
	@AfterTest
	public void CloseDriver()
	{
		Driver.quit();
	}

}
