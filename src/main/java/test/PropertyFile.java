package test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;

import io.appium.java_client.android.AndroidDriver;

	public class PropertyFile
	{	
WebDriver driver;
	
	public void setup() throws FindFailed, InterruptedException, IOException {

		//File app = new File("E:/apks/Wonka_com.zynga.wonka.apk");
		File app = new File("D:/apk/Wonka_com.zynga.wonka.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");

		capabilities.setCapability("AutomationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "Galaxy S6");
		capabilities.setCapability("newCommandTimeout", 2000);

		capabilities.setCapability("app", app);
		capabilities.setCapability("appPackage", "com.zynga.wonka");
		capabilities.setCapability("appActivity", "com.zynga.wonka.Wonka");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}
	}