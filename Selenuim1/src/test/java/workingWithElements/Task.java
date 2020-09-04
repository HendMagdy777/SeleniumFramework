package workingWithElements;

import static org.testng.Assert.assertEquals;

//import java.awt.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Task {
 

	ChromeDriver webDriver ;
	@BeforeTest
	public void OpenUrl()
	{
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		webDriver = new ChromeDriver();
		webDriver.navigate().to("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
		//Driver.navigate().to("http://the-internet.herokuapp.com/tables");
	}


	@Test(enabled = false)
	public void CheckValidCredentials() throws InterruptedException
	{
		WebElement Email =    webDriver.findElement(By.id("email-input"));
		WebElement Password =    webDriver.findElement(By.id("password-input"));
		WebElement LoginButton =    webDriver.findElement(By.id("login-button"));

		Email.sendKeys("login@codility.com");
		//Thread.sleep(2000);
		Password.sendKeys("password");
		//Thread.sleep(2000);
		LoginButton.click();
		//Thread.sleep(2000);
		WebElement message =  webDriver.findElement(By.xpath("//*[@id=\"container\"]/div"));
		assertEquals("Welcome to Codility" , message.getText());

	}

	@Test(enabled = false)
	public void CheckINValidCredentials() throws InterruptedException
	{
		WebElement Email =    webDriver.findElement(By.id("email-input"));
		WebElement Password =    webDriver.findElement(By.id("password-input"));
		WebElement LoginButton =    webDriver.findElement(By.id("login-button"));

		Email.sendKeys("unknown@codility.com");
		//Thread.sleep(2000);
		Password.sendKeys("Password");
		//Thread.sleep(2000);
		LoginButton.click();
		//Thread.sleep(2000);
		WebElement message =  webDriver.findElement(By.xpath("//*[@id='messages']/div"));
		assertEquals("You shall not pass! Arr!" , message.getText());

	}
	
	@Test(enabled = false)
	public void MailValidations() throws InterruptedException
	{
		WebElement Email =    webDriver.findElement(By.id("email-input"));
		WebElement Password =    webDriver.findElement(By.id("password-input"));
		WebElement LoginButton =    webDriver.findElement(By.id("login-button"));

		Email.sendKeys("unknown.com");
		//Thread.sleep(2000);
		Password.sendKeys("Password");
		//Thread.sleep(2000);
		LoginButton.click();
		//Thread.sleep(2000);
	//	"validation error"
		WebElement message =  webDriver.findElement(By.xpath("//*[@id=\"messages\"]/div"));
		assertEquals("Enter a valid email" , message.getText());

	}
	
	@Test
	public void EmptyEmail() throws InterruptedException
	{
		WebElement Email =    webDriver.findElement(By.id("email-input"));
		WebElement Password =    webDriver.findElement(By.id("password-input"));
		WebElement LoginButton =    webDriver.findElement(By.id("login-button"));

		Email.sendKeys("");
		//Thread.sleep(2000);
		Password.sendKeys("Password");
		//Thread.sleep(2000);
		LoginButton.click();
		//Thread.sleep(2000);
		
		WebElement message =  webDriver.findElement(By.cssSelector("div.validation.error"));
		//WebElement message =  webDriver.findElement(By.xpath("//*[@id='messages']/div"));
		assertEquals("Email is required" , message.getText());

	}
	
	@Test(enabled = false)
	public void EmptyPassword() throws InterruptedException
	{
		WebElement Email =    webDriver.findElement(By.id("email-input"));
		WebElement Password =    webDriver.findElement(By.id("password-input"));
		WebElement LoginButton =    webDriver.findElement(By.id("login-button"));

		Email.sendKeys("login@codility.com");
		//Thread.sleep(2000);
		Password.sendKeys("");
		//Thread.sleep(2000);
		LoginButton.click();
		//Thread.sleep(2000);
		WebElement message =  webDriver.findElement(By.xpath("//*[@id='messages']/div"));
		assertEquals("Password is required" , message.getText());

	}

	


	@AfterTest
	public void CloseDriver()
	{
		webDriver.quit();
	}
}



