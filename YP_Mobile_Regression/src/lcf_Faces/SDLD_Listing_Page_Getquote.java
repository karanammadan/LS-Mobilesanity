package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//18
public class SDLD_Listing_Page_Getquote extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void lcfposting() throws InterruptedException, Exception, IOException  {
		 String url="http://www.sulekha.com/vending-machine-dealers/chennai";
		 Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    
	
//Click Get Quote
	    try{
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//li[@data-id='17983']")).isDisplayed();
	    	Thread.sleep(1000);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
	    	
	    	String s=driver.findElement(By.xpath("//div[4]/div[2]/div[1]/ol/li[1]/div[3]/ul/li[3]/a")).getText();
	    	System.out.println(s);
	    	Reporter.log("Click button name : "+s);
	    	driver.findElement(By.xpath("//div[4]/div[2]/div[1]/ol/li[1]/div[3]/ul/li[3]/a")).click();
	    	Thread.sleep(1000);
	    	
	 //Need select    	
	    	String t1= driver.findElement(By.xpath("//label[@for='smulti2']")).getText();
	    	System.out.println(t1);
    		Reporter.log("Selected type: "+t1);
    		driver.findElement(By.xpath("//label[@for='smulti2']")).click();
    		
	    }catch (Exception e1){System.out.println(e1);}
	    	
//Select user Mobile
			 
			   try{
				   Thread.sleep(1000);
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("Entered mobile no.: "+YPMob);
				   }catch(Exception ie2){
						
					 }	  
				
			   
//select Name   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("Entered Name: "+YPName);
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
					 driver.findElement(By.xpath("//button[@class='btn-p getquotesbtn']")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}				
				
				
//Verify code
				   try{

					   WebDriverWait w=new WebDriverWait(driver, 60);
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				   
				   
//Verify button
					try{
						Thread.sleep(500); 
						 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
						}catch(Exception ie221){
							
						}


					driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
					
					 for(int i =0;i<=10;i++){
						   System.out.println(i);
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie8){
					    	   
					       }
						 
						 	try{
						 		System.out.println("second try");
								   if(driver.getCurrentUrl().contains("dashboard")){					
									  Reporter.log(  "Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(2000); 
						   if(i==10||f==1){
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
