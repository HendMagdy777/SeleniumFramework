package workingWithElements;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class CheckAllBrokenLinks {
	ChromeDriver Driver ;

	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/");
		Driver.manage().window().maximize();
	} 

	@Test
	public void TestBrokenLinks()
	{// 3yza a3de 3la link link w at2k eno sha8al tmm
		List<WebElement> links = Driver.findElements(By.tagName("a"));
		//total number of links
		System.out.println("Total Number of Links : " + links.size());
		for(int i = 0 ; i <links.size() ; i++)
		{	WebElement iter = links.get(i);
			String link = iter.getAttribute("href");
			ValidLink(link);
		}
	}

	//Test en l link sha8al asln
	public static void ValidLink(String urllink)
	{
		try {
			URL Link = new URL(urllink);
			HttpURLConnection con =   (HttpURLConnection) Link.openConnection();
			con.setConnectTimeout(2000);
			con.connect();

			//Get Response Code
			if(con.getResponseCode() ==  200)
			{
				System.out.println(urllink +"----" + con.getResponseMessage());
			}

			if(con.getResponseCode() == 404)
			{System.out.println(urllink +"----" + con.getResponseMessage());

			}
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
