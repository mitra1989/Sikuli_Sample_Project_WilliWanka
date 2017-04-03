package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.sikuli.script.*;


public class Test_Sikuli {
	public class Sikuli_Test {

		@Test
		public void Test() throws FindFailed {
		  
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();              
	        driver.get("http://www.google.com");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	       // ImageLocator.setBundlePath("D:/workspace/Sikuli_Sample_Project");
		//Create and initialize an instance of Screen object    
		Screen screen = new Screen();
		//screen.find("D:/images.png");
		screen.click("images.png",0);
		

		  }
		}

}
