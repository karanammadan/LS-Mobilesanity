package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Library.DriverScript;
import Library.Locators;

public class SDLD_Standalone_LCF extends DriverScript implements Locators 
{
	
	int f;
	
	@Test()
	
	public void SDLD_Standalone_LCF() throws InterruptedException, Exception, IOException 
	{

		/*File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		
		 Workbook wb = Workbook.getWorkbook(src);
		 
		 String url = wb.getSheet(0).getCell(1,12).getContents();
		 
		 System.out.println(url);*/
		 
		String url="http://www.sulekha.com/catering-services/chennai?tp=getquotes";
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.get(url);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Select need
	    
	    Thread.sleep(1000);
	    WebElement el=driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label"));
	    	
	    String s=el.getText();
	    	
	    el.click();
	    Reporter.log("type select is "+s);
	    	
	    Thread.sleep(2000);	    

//Select locality
	    
	    try
	    {
	    			
	    	WebElement loc= driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[1]/div/div/div[1]"));
	    	loc.click();
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[1]/div/div/div[2]/div[3]/ul/li[4]/label")).click();
	    	Thread.sleep(1000);
	    	String l=loc.getText();
	    	System.out.println(l);
	    	Reporter.log("locality selected is :" +l);
	    		    	
	    }catch (Exception e2){System.out.println(e2);}
	    
	    	
//Select user Mobile
			 
		try
		{
			driver.findElement(By.name("lcftxtmobile")).clear();
			driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
			Reporter.log("Entered mobile no.: "+YPMob);
		}catch(Exception ie2){}	  
				
			   
//select Name   
			 
		try
		{
			driver.findElement(By.name("lcftxtname")).clear();
			driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
			Reporter.log("Entered Name: "+YPName);
		}catch(Exception ie3){ }	  
			   
//select mail id  
			   
		try
		{
			driver.findElement(By.name("lcftxtemail")).click();
			driver.findElement(By.name("lcftxtemail")).clear();
		}catch(Exception ie4){	}	
	   
			
//Click Next
			   
		try
		{ 
			driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[8]/button[2]")).click();
		}catch(Exception ie6)
		{
			System.out.println(ie6);
		}				
				
				
//Verify code
		try
		{
			WebDriverWait w=new WebDriverWait(driver, 60);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
			Thread.sleep(500);
			driver.findElement(By.name("lcftxtvcode")).clear();
			driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
		}catch(Exception ie124){}	
				   
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[4]/div/div/a")).click();
	
		System.out.println("Secondary LCF skipped");
				   
		String str2= driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[5]/p[1]/strong")).getText();
		if(str2.contains("You have successfully posted your requirement for "))
		{
			System.out.println("LCF posted sucessfully");
			Reporter.log("LCF posted sucessfully");
		}else
			{
				System.out.println("LCF Posting failed");
				Reporter.log("LCF Posting failed");
				Assert.fail();
			}
		
	 }		

	@AfterTest
	public void after()
	{
		driver.quit();
	}
	

}
