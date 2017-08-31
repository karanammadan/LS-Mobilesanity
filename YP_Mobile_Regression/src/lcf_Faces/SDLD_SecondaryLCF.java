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
//21
public class SDLD_SecondaryLCF extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void SDLD_SecondaryLCF () throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/air-cooler-dealers/chennai";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    try{
	    	
	    	String t1= driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label")).getText();
	    	System.out.println(t1);
    		Reporter.log(t1);
    		Thread.sleep(500);
    		driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label")).click();
    		
	    	Thread.sleep(1000);

	    }catch (Exception e1) {}
    	
//Select user Mobile
			 
			   try{	
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("selected mobile  :"+YPMob);
				   }catch(Exception ie2){
						
					 }	  
							   
//select Name   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("selected Name  :"+YPName);
				   }catch(Exception ie3){
						
					 }	  
			   
//select mail id  
			   
			   try{
				   driver.findElement(By.name("lcftxtemail")).click();
				   driver.findElement(By.name("lcftxtemail")).clear();
				   }catch(Exception ie4){
						
				}	
		
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[2]/div[9]/button[2]")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				
	//verify code
				   try{
					   WebDriverWait w=new WebDriverWait(driver, 30);
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				   
				   
	//verify button
					try{
				//		Thread.sleep(500);
						 String s=driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[4]/div/strong")).getText();	
						 if(s.contains("Do you also need any of the services listed below?")){
							 System.out.println("landed on secondary LCF");
							 Reporter.log("sucessfully landed on seondary LCF");
							 
							WebElement el=driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[4]/div/ul/li/label"));
							String s1=el.getText();
							System.out.println("secondary need is: " +s1);
							el.click();
							
							driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[4]/div/ul/li/textarea")).sendKeys("need home services");
							Thread.sleep(3000);
							
							driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[4]/div/div/button")).click();
							
							Thread.sleep(3000);
							String thnq=driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[5]/h4")).getText();
						
							if(thnq.contains("Thank you,")){
							
								System.out.println("secondary LCF sucessfully posted");
								Reporter.log("secondary LCF sucessfully posted");
							}
						 }else {
							 System.out.println("Seconday LCF not displayed");
							 Reporter.log("Secondary LCF not displayed");
							 Assert.fail();
						 }
						}catch(Exception ie221){
							
						}


				  	}
		
		@AfterTest
		public void after(){
		driver.quit();
		}
	

	
} 
