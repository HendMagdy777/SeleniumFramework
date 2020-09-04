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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileUsingRopot {
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
		// lW el image l type bt3ha msh file hyb2a fe moshkla l tre2a l fatt msh htnf3
		// l mkan bta3 choose file msln m7tot fe shakl text box y5od path msh f shkl button w a3ml load s3tha ha7tag l ropot da
		// b3ml check b inspect 3la mkan l chose file msh l uplad
		// so kda msh hynf3 sendkeys
		String ImgName = "HebaBD";
		String ImgPath = System.getProperty("user.dir")+"\\Upload\\"+ImgName;
		WebElement ChooseFileButton = Driver.findElement(By.id("file-upload"));
		
		 
		 
		ChooseFileButton.click();
		System.out.println(ImgPath);
		
		// Code using Ropot
		Robot ropot = new Robot();
		//H3ml copy
		StringSelection selection_Copy = new StringSelection(ImgPath);
		// 3yza a egeb data mn clipboad[ eli 3mlalo copy y3ni]
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection_Copy, null);
		System.out.println("Copy");
		
		// hdos enter
		ropot.keyPress(KeyEvent.VK_ENTER);
		// hseb l mouse
		ropot.keyRelease(KeyEvent.VK_ENTER);
			//3yza a25ro shwya
		ropot.delay(200);
		
		System.out.println("Copy2");
		
		//Ctrl V
		ropot.keyPress(KeyEvent.VK_CONTROL);
		ropot.keyPress(KeyEvent.VK_V);
		ropot.keyRelease(KeyEvent.VK_CONTROL);
		ropot.keyRelease(KeyEvent.VK_V);
		ropot.delay(200);
		ropot.keyPress(KeyEvent.VK_ENTER);
		ropot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Copy3");
		
		WebElement UploadFileButton = Driver.findElement(By.id("file-submit"));
		UploadFileButton.click();
		WebElement UploadedLabel = Driver.findElement(By.id("uploaded-files"));
		System.out.println(UploadedLabel.getText());
		assertEquals(ImgName, UploadedLabel.getText());
	 
	}
	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
