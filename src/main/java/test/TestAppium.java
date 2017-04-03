package test;

import java.io.File;
import java.io.IOException;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
public class TestAppium {
	WebDriver driver;
	int waitTime = 1000;
	String timestamp;
	String timestampMOTD;
	int day, month, year;
	int second, minute, hour;
	GregorianCalendar date = new GregorianCalendar();
	GenericClass gc = new GenericClass();
	PropertyFile pf = new PropertyFile();

	//@BeforeSuite
	public void launchApp() throws FindFailed, InterruptedException, IOException {
				Screen sc = new Screen();
         pf.setup();
		// Waiting for Settings Button on Home Screen to click
		Thread.sleep(5000);
		sc.wait("D:/Wanka project/New Images/Home_screen/home_launched.png",waitTime);
		Boolean returnValue = exists("D:/Wanka project/New Images/Home_screen/home_launched.png", sc);
		// sc.wait("D:/Wonka project/New Images/Home_screen/home_launched.png",
		// waitTime);

		Assert.assertTrue(returnValue, "home_launched.png not found");
		Thread.sleep(5000);

		// Dismiss the MOTD
		gc.motdHandle();
	}

	// Lobby 1 Settings button and build check
	@Test(priority = 1)
	public void lobby1Testcase() throws InterruptedException, FindFailed, IOException {
		Screen sc = new Screen();
		gc.motdHandle();
		// Waiting for Settings Button on Home Screen to click
		sc.wait("D:/Wanka project/New Images/Home_screen/Home_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Home_screen/Home_setting.png", sc),
				"Home_setting.png not found");
		// Clicking Settings Button
		sc.find("D:/Wanka project/New Images/Home_screen/Home_setting.png").click();

		// Waiting for Settings Close Button on Home Screen to click
		sc.wait("D:/Wanka project/New Images/Home_screen/Setting_Closing.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Home_screen/Setting_Closing.png", sc),
				"Setting_Closing.png not found");
		// Clicking Settings Close Button
		sc.find("D:/Wanka project/New Images/Home_screen/Setting_Closing.png").click();

		// Waiting for Settings Button on Home Screen to click
		sc.wait("D:/Wanka project/New Images/Home_screen/Home_setting.png", waitTime).click();
		Assert.assertTrue(exists("D:/Wanka project/New Images/Home_screen/Home_setting.png", sc),
				"Home_setting.png not found");
		// Clicking Settings Button
		sc.find("D:/Wanka project/New Images/Home_screen/Home_setting.png").click();

		Thread.sleep(3000);
		// Waiting for Sound Option
		Settings st = new Settings();
		st.MoveMouseDelay = 1;
		sc.wait("D:/Wanka project/New Images/Home_screen/Soun_click.png", waitTime);
		sc.find("D:/Wanka project/New Images/Home_screen/Soun_click.png").click();
		sc.dragDrop("D:/Wanka project/New Images/Home_screen/Soun_click.png",
				"D:/Wanka project/New Images/Home_screen/dragDropDest.png");
		Thread.sleep(2000);

		// Waiting for about option and click
		st.MoveMouseDelay = 0;
		sc.wait("D:/Wanka project/New Images/Home_screen/home_about.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Home_screen/home_about.png", sc),
				"home_about.png not found");
		sc.find("D:/Wanka project/New Images/Home_screen/home_about.png").click();
		Thread.sleep(5000);

		// Waiting for about page to load
		sc.wait("D:/Wanka project/New Images/Home_screen/about.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Home_screen/about.png", sc), "about.png not found");

		// Taking screen short for build
		gc.takeSnapBuild();

		// Waiting for about close option and click
		sc.wait("D:/Wanka project/New Images/Home_screen/about_close.png", waitTime).click();

	}

	// Room 1 checks
	//@Test(priority = 2)
	public void room1TestCase() throws InterruptedException, FindFailed, IOException {
		Screen sc = new Screen();
		try{
		sc.wait("D:/Wanka project/New Images/Room1/close_golden_ticket.png", 15);
		sc.find("D:/Wanka project/New Images/Room1/close_golden_ticket.png").click();
		}
		catch(Exception e)
		{
			System.out.println("No golden_ticket found");
			
		}
		
		sc.wait("D:/Wanka project/New Images/Room2/room2_reference.png",20);
		
		sc.dragDrop("D:/Wanka project/New Images/Room2/room2_reference.png",
				"D:/Wanka project/New Images/Room3/room3_reference.png");
		
		//sc.wait("D:/Wanka project/New Images/Room1/Room1_reference.png", 30);
		// Setting room1 region
		Location room1RegionLoc = sc.find("D:/Wanka project/New Images/Room1/Room1_reference.png").getCenter();
		Region room1Region = sc.newRegion(room1RegionLoc, 600, 600);

		// Waiting for home page to load
		sc.wait("D:/Wanka project/New Images/Room1/Room1_reference.png", waitTime);
		room1Region.wait("D:/Wanka project/New Images/Room1/Room1_entry", waitTime);
		// Clicking room 1 entry button
		room1Region.find("D:/Wanka project/New Images/Room1/Room1_entry").click();
		Thread.sleep(2000);
		// handling addon
		//gc.addonHandle();

		/*// Spinning inside room
		sc.wait("D:/Wanka project/New Images/Room1/Spin_room1.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Spin_room1.png", sc), "Spin_room1.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Spin_room1.png").click();
		Thread.sleep(5000);*/
		// gc.progresion();

		// Room1 settings
		sc.wait("D:/Wanka project/New Images/Room1/Room1_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Room1_setting.png", sc),
				"Room1_setting.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Room1_setting.png").click();

		// Room1 paytable
		sc.wait("D:/Wanka project/New Images/Room1/Paytable_room1.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Paytable_room1.png", sc),
				"Paytable_room1.png not found");
		//sc.find("D:/Wanka project/New Images/Room1/Paytable_room1.png").right(2000)
		//		.find("D:/Wanka project/New Images/Room1/click_paytable.png").click();
		sc.find("D:/Wanka project/New Images/Room1/Paytable_room1.png").click();
		Thread.sleep(3000);

		// room1 settings close
		sc.wait("D:/Wanka project/New Images/Room1/Room1_setting_close.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Room1_setting_close.png", sc),
				"Room1_setting_close.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Room1_setting_close.png").click();

		// return to lobby
		sc.wait("D:/Wanka project/New Images/Room1/Return_home.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Return_home.png", sc), "Return_home.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Return_home.png").click();
		Thread.sleep(5000);
		gc.motdHandle();

	}

	// Room 2 checks
	//@Test(priority = 3)
	public void room2TestCase() throws InterruptedException, FindFailed, IOException {
		Screen sc = new Screen();

		// Room2 Entry
		sc.wait("D:/Wanka project/New Images/Room2/room2_reference.png", waitTime);
		Location room2RegionLoc = sc.find("D:/Wanka project/New Images/Room2/room2_reference").getCenter();
		Region room2Region = sc.newRegion(room2RegionLoc, 600, 600);
		room2Region.wait("D:/Wanka project/New Images/Room2/room2_entry", waitTime);
		room2Region.find("D:/Wanka project/New Images/Room2/room2_entry").click();
		Thread.sleep(6000);
		gc.addonHandle();

		// Room2 spins
		sc.wait("D:/Wanka project/New Images/Room2/Spin_room2.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Spin_room2.png", sc), "Spin_room2.png not found");
		sc.find("D:/Wanka project/New Images/Room2/Spin_room2.png").click();
		Thread.sleep(5000);
		gc.progresion();
		
		// Room2 settings
		sc.wait("D:/Wanka project/New Images/Room2/Room2_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Room2_setting.png", sc),
				"Room2_setting.png not found");
		sc.find("D:/Wanka project/New Images/Room2/Room2_setting.png").click();

		// Room2 paytable
		sc.wait("D:/Wanka project/New Images/Room2/Paytable_room2.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Paytable_room2.png", sc),
				"Paytable_room2.png not found");
		/*sc.find("D:/Wanka project/New Images/Room2/Paytable_room2.png").right(2000)
				.find("D:/Wanka project/New Images/Room2/click_paytable.png").click();*/
		sc.find("D:/Wanka project/New Images/Room2/Paytable_room2.png").click();
		Thread.sleep(3000);

		// Room2 settings close
		sc.wait("D:/Wanka project/New Images/Room2/Room2_setting_close.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Room2_setting_close.png", sc),
				"Room2_setting_close.png not found");
		sc.find("D:/Wanka project/New Images/Room2/Room2_setting_close.png").click();

		// Returning to lobby
		sc.wait("D:/Wanka project/New Images/Room2/Return_home.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Return_home.png", sc), "Return_home.png not found");
		sc.find("D:/Wanka project/New Images/Room2/Return_home.png").click();
		Thread.sleep(5000);
		// Dismiss the MOTD
		gc.motdHandle();

		// Lobby2 navigation
		sc.wait("D:/Wanka project/New Images/Room2/Navigate_lobby2.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room2/Navigate_lobby2.png", sc),
				"Navigate_lobby2.png not found");
		sc.find("D:/Wanka project/New Images/Room2/Navigate_lobby2.png").click();

		sc.wait("D:/Wanka project/New Images/Room2/World_refrence.png", waitTime);
		sc.find("D:/Wanka project/New Images/Room2/World_refrence.png").right(2000)
				.find("D:/Wanka project/New Images/Room2/lobby2_entry.png").click();
		Thread.sleep(6000);
		// Dismiss the MOTD
		gc.motdHandle();

	}

	// Lobby 2 settings button checks
	//@Test(priority = 4)
	public void lobby2TestCase() throws MalformedURLException, InterruptedException, FindFailed {
		Screen sc = new Screen();

		// lobby 2 settings
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Room3_region.png", waitTime);
		sc.wait("D:/Wanka project/New Images/lobby 2/Lobby2_settings.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby 2/Lobby2_settings.png", sc),
				"Lobby2_settings.png not found");
		sc.find("D:/Wanka project/New Images/lobby 2/Lobby2_settings.png").click();

		// lobby 2 music button
		sc.wait("D:/Wanka project/New Images/lobby 2/musicsmall.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby 2/musicsmall.png", sc), "musicsmall.png not found");
		sc.find("D:/Wanka project/New Images/lobby 2/musicsmall.png").click();
		Thread.sleep(3000);

		// lobby 2 sound button
		sc.wait("D:/Wanka project/New Images/lobby 2/musicsmall.png", waitTime);
		sc.find("D:/Wanka project/New Images/lobby 2/musicsmall.png").click();
		sc.wait("D:/Wanka project/New Images/lobby 2/Soun_click.png", waitTime).click();
		Thread.sleep(2000);

		// close setting button
		sc.wait("D:/Wanka project/New Images/lobby 2/Soun_click.png", waitTime).click();
		sc.wait("D:/Wanka project/New Images/lobby 2/lobby2_settings_close.png", waitTime).click();

	}

	// Room 3 checks
	//@Test(priority = 5)
	public void room3TestCase() throws InterruptedException, FindFailed, IOException {

		Screen sc = new Screen();
		Location room3RegionLoc = sc.find("D:/Wanka project/New Images/lobby2Room1/Room3_region.png").getCenter();
		Region room3Region = sc.newRegion(room3RegionLoc, 400, 400);
		room3Region.wait("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png", waitTime);
		room3Region.find("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png").click();

		// Waiting for lobby2 room entry button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png", sc),
				"lobby2room1_entry.png not found");
		// Clicking lobby2 room entry button
		sc.find("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png").click();
		Thread.sleep(2000);
		gc.addonHandle();

		// Waiting for lobby2 room spin button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Spin_room1.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Spin_room1.png", sc),
				"Spin_room1.png not found");
		// Clicking lobby2 room spin button
		sc.find("D:/Wanka project/New Images/lobby2Room1/Spin_room1.png").click();
		Thread.sleep(5000);

		// progression
		//gc.progresion();

		// Waiting for Lobby2 room settings button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png", sc),
				"Room3_setting.png not found");
		// Clicking Lobby2 room settings button
		sc.find("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png").click();

		// Waiting for Lobby2 room close button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/room2_close.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/room2_close.png", sc),
				"room2_close.png not found");
		// Clicking Lobby2 room close button
		sc.find("D:/Wanka project/New Images/lobby2Room1/room2_close.png").click();

		// Clicking Lobby2 room settings button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png", sc),
				"Room3_setting.png not found");
		sc.find("D:/Wanka project/New Images/lobby2Room1/Room3_setting.png").click();

		// Clicking Lobby2 room paytable button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Paytable_room1", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Paytable_room1.png", sc),
				"Paytable_room1.png not found");
		/*sc.find("D:/Wanka project/New Images/lobby2Room1/Paytable_room1").right(2000)
				.find("D:/Wanka project/New Images/Room1/click_paytable.png").click();*/
		sc.find("D:/Wanka project/New Images/lobby2Room1/Paytable_room1").click();
		Thread.sleep(3000);

		// Clicking Lobby2 room paytable close button
		sc.wait("D:/Wanka project/New Images/lobby2Room1/room2_close.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/room2_close.png", sc),
				"room2_close.png not found");
		sc.find("D:/Wanka project/New Images/lobby2Room1/room2_close.png").click();

		// return to lobby
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Return_home.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Return_home.png", sc),
				"Return_home.png not found");
		sc.find("D:/Wanka project/New Images/lobby2Room1/Return_home.png").click();
		Thread.sleep(5000);

		// handle MOTD
		gc.motdHandle();
	}

	//@Test
	public void Ftue() throws FindFailed, IOException, InterruptedException
	{
		Screen sc = new Screen();
		

		
		sc.find("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png").click();
		Thread.sleep(15000);
		
		sc.wait("D:/Wanka project/New Images/lobby2Room1/Spin_room1.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/lobby2Room1/Spin_room1.png", sc),
				"Spin_room1.png not found");
		
		gc.progresion();
		sc.find("D:/Wanka project/New Images/lobby2Room1/Return_home.png").click();
		Thread.sleep(5000);
		gc.motdHandle();
		
		sc.find("D:/Wanka project/FTUE_Images/VIP.png").click();
		Thread.sleep(4000);
		sc.find("D:/Wanka project/FTUE_Images/Back_to_lobby.png").click();
		gc.motdHandle();
		sc.find("D:/Wanka project/New Images/lobby2Room1/lobby2room1_entry.png").click();
		Thread.sleep(5000);
		sc.wait("D:/Wanka project/New Images/Room1/Room1_setting.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Room1_setting.png", sc),
				"Room1_setting.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Room1_setting.png").click();

		// Room1 paytable
		sc.wait("D:/Wanka project/New Images/Room1/Paytable_room1.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Paytable_room1.png", sc),
				"Paytable_room1.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Paytable_room1.png").right(2000)
				.find("D:/Wanka project/New Images/Room1/click_paytable.png").click();
		Thread.sleep(3000);

		// room1 settings close
		sc.wait("D:/Wanka project/New Images/Room1/Room1_setting_close.png", waitTime);
		Assert.assertTrue(exists("D:/Wanka project/New Images/Room1/Room1_setting_close.png", sc),
				"Room1_setting_close.png not found");
		sc.find("D:/Wanka project/New Images/Room1/Room1_setting_close.png").click();
		
	//FTUE Level-up Progressions
	//level-2 Progressions
		gc.progresion(9);
	
	}
	
	// Method to check Assert
	private boolean exists(String image, Screen sc) throws FindFailed {
	
			if (sc.wait(image, 20).find(image) != null) {
				return true;
			} else
				return false;

		
		}
	}


