package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test_Zynga_Mobile {
	@Test
	public void launchTheApp() throws MalformedURLException, InterruptedException, FindFailed
	{
	 File app = new File("D:\\apk\\ZAP 4.8.1_com.zynga.sdk.mobileads.apk");
	 DesiredCapabilities capabilities=new DesiredCapabilities();
	 capabilities.setCapability("AutomationName", "Appium");
	 capabilities.setCapability("platformName","Android");
	 capabilities.setCapability("platformVersion", "5.0");
	 capabilities.setCapability("deviceName", "Indium Galaxy s5");
	 capabilities.setCapability("app",app);
	 capabilities.setCapability("appPackage","com.zynga.sdk.mobileads");
	 capabilities.setCapability("appActivity","com.zynga.sdk.mobileads.demo.ui.MainActivity");
	 AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	 System.out.println("checking");
	 WebDriverWait wait = new WebDriverWait(driver, 60);
	 wait.until(ExpectedConditions.presenceOfElementLocated((By.name("Interstitial")))); 
	 //driver.findElementByName("Interstitial").click();
	 //driver.findElement(ByName("Interstitial"));
	 TouchAction tAct = new TouchAction(driver);
	 
	 WebElement ele = driver.findElement(By.name("Interstitial"));
	 driver.tap(1,ele ,10);
	 
	 
	}

}
