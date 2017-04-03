package test;

import java.io.File;
import test.TestListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import org.testng.Assert;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.testng.ITestListener;

public class GenericClass {
	
	//private ScreenImage file;
	String buildNumber="Build.info";
	TestListener tl = new TestListener();
	  int flag = 1;
                    
    static int motdCount =0; 
    public String Calender(){
		 GregorianCalendar date = new GregorianCalendar();
			int day, month, year;
		    int second, minute, hour;
		    int waitTime=1000;
			day = date.get(Calendar.DAY_OF_MONTH);
		    month = date.get(Calendar.MONTH);
		    year = date.get(Calendar.YEAR);
		    month=month+1;
		    second = date.get(Calendar.SECOND);
		    minute = date.get(Calendar.MINUTE);
		    hour = date.get(Calendar.HOUR);
		    String timestamp = year+"_"+month+"_"+day+"_"+hour+"_"+minute;
		return timestamp;
    }	
    Screen sc=new Screen();
	
    //Build snapshot Method
    public void takeSnapBuild() throws IOException
	{
		Screen sc=new Screen();
		ScreenImage file = sc.capture(sc.getBounds());
		file.getImage();
		String timestamp = Calender();
		File theDir = new File("D:/Wanka project/New Images/Build_images/"+timestamp);

		 // if the directory does not exist, create it
		if (!theDir.exists()) {
		     System.out.println("creating directory: " + theDir);
		     boolean result = false;

		     try{
		         theDir.mkdir();
		         result = true;
		     } 
		     catch(SecurityException se){
		     System.out.println("Not able to create Directory"+ se);
		     }        
		     if(result) {    
		         System.out.println("DIR created");  
		     }
		 }
		
		File outputfile = new File("D:/Wanka project/New Images/Build_images/"+timestamp+"/"+buildNumber+".png");
	    ImageIO.write(file.getImage(), "png", outputfile);
	}

    //Progression Method
	public void progresion() throws IOException, FindFailed, InterruptedException
	{
		Screen sc=new Screen();
		sc.wait("D:/Wanka project/New Images/Room1/Spin_room1",30).click();
	    Thread.sleep(5000);
	    int flag=1;
	   
	    while(flag==1)
	    {
	
	    if(sc.exists("D:/Wanka project/New Images/progression images/levelup_refrence",8) == null)
	    { 
	    		
	    	sc.wait("D:/Wanka project/New Images/progression images/increse_bet",30).click();
	    	sc.wait("D:/Wanka project/New Images/progression images/Spin_room1",30).click();
	    	flag=1;
	    	
	    	
	    }
	    else
	    {
	    	flag=0;
	    }
	    }
	   
	    sc.wait("D:/Wanka project/New Images/progression images/close_levelup_dialog",50).click();
	    sc.wait("D:/Wanka project/New Images/progression images/after_close",50).click();
	}

	//add-on Handle Method
	public void addonHandle() throws FindFailed
	{
		
		
		sc.wait("D:/Wanka project/New Images/Addon/Addon_reference",90);
		sc.find("D:/Wanka project/New Images/Addon/Addon_reference").below(500).find("D:/Wanka project/New Images/Addon/intial_click").click();
		
		}
	
	//MOTD Handle Method
public void motdHandle() throws FindFailed, InterruptedException, IOException {
			
		while((sc.exists("D:/Wanka project/New Images/motd/MotdClose1",2) != null)||(sc.exists("D:/Wanka project/New Images/motd/okbutton",2) != null)|| (sc.exists("D:/Wanka project/New Images/motd/frenzyokbutton",2)!=null)||(sc.exists("D:/Wanka project/New Images/motd/okbutton1",2) != null))
		
		{
			if(sc.exists("D:/Wanka project/New Images/motd/MotdClose1",2) != null)
			{
			sc.wait("D:/Wanka project/New Images/motd/MotdClose1",2);
		
			takeMOTDSnap();
			sc.find("D:/Wanka project/New Images/motd/MotdClose1").click();
			
			Thread.sleep(1000);
			
			}
			
			else if(sc.exists("D:/Wanka project/New Images/motd/okbutton",2)!= null)
			{
				
			sc.wait("D:/Wanka project/New Images/motd/okbutton",2);
			takeMOTDSnap();
			sc.find("D:/Wanka project/New Images/motd/okbutton").click();
			
			}
			
			else if ((sc.exists("D:/Wanka project/New Images/motd/frenzyokbutton",2) !=null))
			{
		
			sc.wait("D:/Wanka project/New Images/motd/frenzyokbutton",2);	
			takeMOTDSnap();
			sc.find("D:/Wanka project/New Images/motd/frenzyokbutton").click();
			
			}
			
			else if(sc.exists("D:/Wanka project/New Images/motd/okbutton1",2) != null)
			{
			sc.wait("D:/Wanka project/New Images/motd/okbutton1",2);
			takeMOTDSnap();
			sc.find("D:/Wanka project/New Images/motd/okbutton1").click();
			}
		    }	
            }
		
	 private boolean exist(String image,Screen sc) throws FindFailed {
		 try{
			if(sc.wait(image,7).find(image)!=null)
			{
			  return true;
			}
			else
			return false;
		 }
		 catch(FindFailed e)
		 {
			 return false;
		 }
	 }
	
		 
	//MOTD Snapshot Method
	public void takeMOTDSnap() throws IOException
		{
			Screen sc=new Screen();
			ScreenImage file = sc.capture(sc.getBounds());
			file.getImage();	
			String timestamp =Calender();
			 File theDir = new File("D:/Wanka project/New Images/MOTD_Images/"+timestamp);

			 // if the directory does not exist, create it
			 if (!theDir.exists()) {
			     System.out.println("creating directory: " + theDir);
			     boolean result = false;

			     try{
			         theDir.mkdir();
			         result = true;
			     } 
			     catch(SecurityException se){
			     System.out.println("Not able to create Directory"+ se);
			     }        
			     if(result) {    
			         System.out.println("MOTD DIR created");  
			     }
			 }
			motdCount++;
			File outputfile = new File("D:/Wanka project/New Images/MOTD_Images/"+timestamp+"/"+"MOTD_"+motdCount+".png");
		    ImageIO.write(file.getImage(), "png", outputfile);
		}
	public void progresion(int levelcount) throws IOException, FindFailed, InterruptedException
	{
		Screen sc=new Screen();
	for(int i=0;i<levelcount;i++)
	{	
		sc.wait("D:/Wanka project/New Images/Room1/Spin_room1",30).click();
	    Thread.sleep(5000);
	    int flag=1;
	   
	    while(flag==1)
	    {
	
	    if(sc.exists("D:/Wanka project/New Images/progression images/levelup_refrence",8) == null)
	    { 
	    		
	    	sc.wait("D:/Wanka project/New Images/progression images/increse_bet",30).click();
	    	sc.wait("D:/Wanka project/New Images/progression images/Spin_room1",30).click();
	    	flag=1;
	    	
	    	
	    }
	    else
	    {
	    	flag=0;
	    }
	    }
	   
	    sc.wait("D:/Wanka project/New Images/progression images/close_levelup_dialog",50).click();
	    sc.wait("D:/Wanka project/New Images/progression images/after_close",50).click();
	}}
	
public void ftue1() throws IOException, FindFailed, InterruptedException
{
	Screen sc=new Screen();
	sc.wait("D:/Wanka project/New Images/Room1/Spin_room1",30).click();
    Thread.sleep(5000);
    int count=0;
    //static int flag = 1; 
    while(count<9)
    {
    while(flag==1)
    {

    if(sc.exists("D:/Wanka project/New Images/progression images/levelup_refrence",8) == null)
    { 
    		
    	//sc.wait("D:/Wanka project/New Images/progression images/increse_bet",30).click();
    	sc.wait("D:/Wanka project/New Images/progression images/Spin_room1",30).click();
    	flag=1;
    	
    	
    }
    else
    {
    	flag=0;
    	count++;  	
    }
    }
   
    sc.wait("D:/Wanka project/New Images/progression images/close_levelup_dialog",50).click();
    sc.wait("D:/Wanka project/New Images/progression images/after_close",50).click();
}   
}	
}
	

