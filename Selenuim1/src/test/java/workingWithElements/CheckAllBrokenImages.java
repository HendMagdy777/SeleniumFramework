package workingWithElements;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.maven.wagon.providers.http.httpclient.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpClient.Builder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class CheckAllBrokenImages {
	ChromeDriver Driver ;
	private int InvalidImages;
	@BeforeTest
	public void OpenUrl()
	{  
		String Path = System.getProperty("user.dir")+"//resources//chromedriver_2.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		Driver = new ChromeDriver();
		Driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
		Driver.manage().window().maximize();
	} 
	@Test
	public void TestBrokenImgs() throws InterruptedException  
	{    InvalidImages = 0;
	List<WebElement> ImgList = Driver.findElements(By.tagName("img"));
	for (WebElement img : ImgList)
	{
		if(img != null )
		{
			VerifyImgActive(img);
		}				
	}

	System.out.println("Number of Broken Images is " + InvalidImages);
	}


	//Check if image is active/exist or not
	public void VerifyImgActive(WebElement ImgElement)
	{	
		HttpClient client = (HttpClient) HttpClientBuilder.create().build();
		// Prepare a request object
		HttpGet Request = new HttpGet(ImgElement.getAttribute("src")); 
		// Execute the request
	//	HttpResponse response = client.execute(httpget);
		// Examine the response status
		//System.out.println(response.getStatusLine());
		//try {
		//	if(response.getStatusLine().getStatusCode() != 200)
			//{
				InvalidImages++; 
			//}
		//} 
	//	catch (ClientProtocolException e) {
		//	e.printStackTrace();		}
	//	catch (IOException ex) {
		//	ex.printStackTrace();	 
		//}
	}

	@AfterMethod
	public void TakeaScreenshot(ITestResult res) throws IOException
	{
		if(ITestResult.FAILURE == res.getStatus())
		{	TakesScreenshot TS = (TakesScreenshot) Driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" +res.getName() +".png"));
		}
	}


	@AfterTest
	public void CloseDriver()
	{Driver.quit();
	}

}
