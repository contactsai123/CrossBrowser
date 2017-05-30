//This test is to execute parallel web tests in CBT environment with parameters driven from TestNG

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser {
	
		String browsername;

		WebDriver driver;
		
		@Test
		
		public void opentest()
		{
				  System.out.println("Inside Test class");

			/*
			if(browsername.equalsIgnoreCase("chrome"))
					{
				System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
				driver = new ChromeDriver();			
				}
			else if(browsername.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "C:\\Softwares\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				}
			else if(browsername.equalsIgnoreCase("FF"))
			{
				//System.setProperty("webdriver.ie.driver", "C:\\Softwares\\IEDriverServer.exe");
				driver = new FirefoxDriver();
				}
		
		*/
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
			String exp = driver.getTitle();
			assertTrue(exp.equals("Google"));		
			System.out.println("Completed");
				
			}



  @BeforeClass
	@Parameters("browsername")
  public void beforeClass(String strbrowser) throws Exception {
	  System.out.println("Inside Before class");
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("os_api_name", "Mac10.11");
	  cap.setCapability("browser_api_name", strbrowser);
	  cap.setCapability("name", "Parallel tests in CBT environment from TestNG");
	  driver = new RemoteWebDriver(new URL("http://contactsai123%40gmail.com:u5fb2503aa02da9c@hub.crossbrowsertesting.com:80/wd/hub"), cap);
	  System.out.println("End of Before class");


  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
