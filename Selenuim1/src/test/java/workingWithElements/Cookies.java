package workingWithElements;

import static org.testng.Assert.assertEquals;


import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cookies {
	ChromeDriver Driver ;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("http://magento-demo.lexiconn.com/");
		Driver.manage().window().maximize();
	} 
	@Test
	public void ChangeLangugeCookiees() throws InterruptedException 
	{ 
		WebElement Lang = Driver.findElement(By.id("select-language"));
		Select selectlist = new Select(Lang);
		assertEquals("English", selectlist.getFirstSelectedOption().getText());

		//Cookiees 
		Cookie CK = Driver.manage().getCookieNamed("store");
		assertEquals(null, CK);

		selectlist.selectByVisibleText("German");
		CK = Driver.manage().getCookieNamed("store");
		assertEquals("german" ,CK.getValue() );

		Set<Cookie> CokList = Driver.manage().getCookies();
		java.util.Iterator<Cookie>  it = CokList.iterator();
		while (it.hasNext()) {
			Cookie Cokk = it.next();
			System.out.println(Cokk.getName());
			System.out.println(Cokk.getDomain());
			System.out.println(Cokk.getPath());
			System.out.println(Cokk.getExpiry());
		}



	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}


}
