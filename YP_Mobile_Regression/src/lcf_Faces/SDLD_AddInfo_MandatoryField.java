package lcf_Faces;

import java.io.IOException;
import org.openqa.selenium.By;
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
//16
public class SDLD_AddInfo_MandatoryField extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void SDLD_AddInfo_MandatoryField() throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/currency-counting-machine-rentals/chennai";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    WebDriverWait w = new WebDriverWait(driver, 20);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/section/div/div/div[1]/div[3]/button[2]"))); 

		
	    
	    	
	    	driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[3]/button[2]")).click();
	    	Thread.sleep(2000);

	    	String t1= driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div/div/span")).getText();
	    	if(t1.contains("Enter additional info")){
	    	
	    	System.out.println("Madatory validation displayed");
    		Reporter.log("Mandatory validation: "+t1);
	    	}
	    	else{
	    		System.out.println("Requirements not mandatory");
	    		Reporter.log("mandatory field is not working");
	    		Assert.fail();
	    	}
    		driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div/div/div/textarea")).sendKeys("Need currency machines");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[3]/button[2]")).click();
    		
    		 w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtmobile")));
    	
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

		
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[9]/button[2]")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}
				
				
				
	//verify code
				   try{
					
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){	
							
						 }	
				   for(int i =0;i<=20;i++){
						 
					 	try{		
					   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
						
						  Reporter.log(  "Lcf posted successfully");
						  break;
					   }			
				       }catch(Exception ie8){
				    	   
				       }
					 
					 	try{
					 		System.out.println("Try : "+i);
							   if(driver.getCurrentUrl().contains("dashboard")){					
								  Reporter.log(  "Lcf posted successfully");
								  break;
							   }			
						       }catch(Exception ie694){
						    	   
						       }
					 	
					 	
					  Thread.sleep(1000); 
					   if(i==20||f==1){
						   Reporter.log(  "Lcf not posted successfully");
						   Assert.fail();
					   }
					 }
				  

	}
		@AfterTest
		public void after(){
		driver.quit();
		} 
	

	
} 