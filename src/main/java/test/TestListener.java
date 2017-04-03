package test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	
	String timeStamp;
	GregorianCalendar date = new GregorianCalendar();
	private ScreenImage file;
	int day, month, year;
    int second, minute, hour;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName=result.getName().toString().trim();
	    day = date.get(Calendar.DAY_OF_MONTH);
	    month = date.get(Calendar.MONTH);
	    year = date.get(Calendar.YEAR);
	    month=month+1;
	    second = date.get(Calendar.SECOND);
	    minute = date.get(Calendar.MINUTE);
	    hour = date.get(Calendar.HOUR);
	    timeStamp= year+"_"+month+"_"+day+"_"+hour+"_"+minute;
	    File theDir = new File("D:/Wanka project/New Images/Failed Test Images/"+timeStamp);

	 // if the directory does not exist, create it
	 if (!theDir.exists()) {
	     System.out.println("creating directory: " + theDir);
	     boolean rst = false;

	     try{
	         theDir.mkdir();
	         rst = true;
	     } 
	     catch(SecurityException se){
	     System.out.println("Not able to create Directory"+ se);
	     }        
	     if(rst) {    
	         System.out.println("DIR created");  
	     }
	 }
		File outputfile = new File("D:/Wanka project/New Images/Failed Test Images/"+timeStamp+"/"+ methodName+"_Fail" + ".png");
	    try {
			ImageIO.write(file.getImage(), "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	} 
		
	   
}
